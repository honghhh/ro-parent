package com.project.log;

import com.project.dao.LogMapper;
import com.project.dto.cms.LoginDto;
import com.project.entity.Log;
import com.project.entity.User;
import com.project.session.CmsSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志
 */
@Component
@Aspect
public class LogAopAction {

    /*
        @Before: 前置通知, 在方法执行之前执行
        @After: 后置通知, 在方法执行之后执行
        @AfterRunning: 返回通知, 在方法返回结果之后执行
        @AfterThrowing: 异常通知, 在方法抛出异常之后
        @Around: 环绕通知, 围绕着方法执行
    */

    // 获取开始时间
    private long BEGIN_TIME;

    // 获取结束时间
    private long END_TIME;

    // 定义本次log实体
    private Log log = new Log();

    // 定义切入点  @Pointcut("execution(* com.project.service..*.*(..))")  -- 表示对com.project.service 包下的所有方法都可添加切入点
    @Pointcut("execution(* com.project.service..*.*(..))")
    private void controllerAspect() {}

    @Autowired
    private LogMapper logMapper;

    /**
     * 方法开始执行
     */
    @Before("controllerAspect()")
    public void doBefore() {
        BEGIN_TIME = new Date().getTime();
    }

    /**
     * 方法结束执行
     */
    @After("controllerAspect()")
    public void after() {
        END_TIME = new Date().getTime();
    }

    /**
     * 方法结束执行后的操作
     */
    @AfterReturning("controllerAspect()")
    public void doAfter() {
        if (log != null) {
            if (log.getState() != null) {
                if (log.getState() == 1 || log.getState() == -1) {
                    if (RequestContextHolder.getRequestAttributes() != null) {
                        // 获取request对象
                        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                        // 获取当前登陆用户信息
                        LoginDto loginUser = CmsSession.getUser(request);
                        if (loginUser == null) {
                            log.setLoginaccount("—— ——");
                        } else {
                            log.setLoginaccount(loginUser.getLogin() + "|" + loginUser.getNickname());
                        }
                        // 执行时长
                        log.setActiontime(END_TIME - BEGIN_TIME);
                        // 执行开始时间
                        log.setGmtcreate(new Date(BEGIN_TIME));
                        logMapper.insertSelective(log);
                    }
                }
            }
        }
    }

    /**
     * 方法有异常时的操作
     */
    @AfterThrowing("controllerAspect()")
    public void doAfterThrow() {}

    /**
     * 方法执行
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 日志实体对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object object = null;
        if (attributes != null) {
            // 获取request对象
            HttpServletRequest request = attributes.getRequest();
            // 拦截的实体类，就是当前正在执行的controller
            Object target = pjp.getTarget();
            // 拦截的方法名称。当前正在执行的方法
            String methodName = pjp.getSignature().getName();
            // 拦截的方法参数
            @SuppressWarnings("unused")
            Object[] args = pjp.getArgs();
            // 拦截的放参数类型
            Signature sig = pjp.getSignature();
            MethodSignature msig = null;
            if (!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) sig;
            @SuppressWarnings("rawtypes")
            Class[] parameterTypes = msig.getMethod().getParameterTypes();
            // 获取当前执行的方法
            Method method = null;
            try {
                method = target.getClass().getMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SecurityException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (null != method) {
                // 判断是否包含自定义的注解，说明一下这里的SystemLog自定义的注解
                if (method.isAnnotationPresent(SystemLog.class)) {
                    SystemLog systemlog = method.getAnnotation(SystemLog.class);
                    log.setModule(systemlog.module());
                    log.setMethod(systemlog.methods());
                    log.setLoginip(getIp(request));
                    log.setActionurl(request.getRequestURI());
                    try {
                        // 环绕通知 = 前置 + 目标方法执行 + 后置通知，proceed方法就是用于启动目标方法执行的
                        object = pjp.proceed();
                        log.setDescription("执行成功");
                        log.setState(1);
                    } catch (Throwable e) {
                        // TODO Auto-generated catch block
                        log.setDescription("执行失败");
                        log.setState(-1);
                    }
                } else {// 没有包含注解
                    // 环绕通知 = 前置 + 目标方法执行 + 后置通知，proceed方法就是用于启动目标方法执行的
                    object = pjp.proceed();
                    log.setDescription("此操作不包含注解");
                    log.setState(0);
                }
            } else { // 不需要拦截直接执行
                // 环绕通知 = 前置 + 目标方法执行 + 后置通知，proceed方法就是用于启动目标方法执行的
                object = pjp.proceed();
                log.setDescription("不需要拦截直接执行");
                log.setState(0);
            }
        } else {
            // 环绕通知 = 前置 + 目标方法执行 + 后置通知，proceed方法就是用于启动目标方法执行的
            object = pjp.proceed();
        }
        return object;
    }

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    private String getIp(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
