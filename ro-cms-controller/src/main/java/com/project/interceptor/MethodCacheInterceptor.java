package com.project.interceptor;

import com.project.utils.redis.RedisUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.List;

/**
 * Redis缓存过滤器
 */
public class MethodCacheInterceptor implements MethodInterceptor {

    private RedisUtil redisUtil;
    private List<String> targetNamesList; // 禁用缓存的类名列表
    private List<String> methodNamesList; // 禁用缓存的方法列表
    private String defaultCacheExpireTime; // 缓存默认的过期时间

    /**
     * 实现MethodInterceptor接口，达到方法执行前后增强
     * @param invocation invocation.proceed()方法为执行controller 可在这个方法前后进行特殊处理
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object value = null;
        // 获取类名
        String targetName = invocation.getThis().getClass().getName();
        // 获取方法名
        String methodName = invocation.getMethod().getName();
        // 如果缓存已存在
        if (!isAddCache(targetName, methodName)) {
            // 跳过缓存执行controller
            return invocation.proceed();
        }
        // 获取参数名
        Object[] arguments = invocation.getArguments();
        // 获取拼接缓存键名
        String key = getCacheKey(targetName, methodName, arguments);
        try {
            // 判断是否有缓存
            if (redisUtil.exists(key)) {
                // 有则直接返回缓存数据不执行controller
                return redisUtil.get(key);
            }
            // 否则执行controller方法 写入缓存
            value = invocation.proceed();
            if (value != null) {
                final String tkey = key;
                final Object tvalue = value;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        redisUtil.set(tkey, tvalue, Long.parseLong(defaultCacheExpireTime));
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (value == null) {
                return invocation.proceed();
            }
        }
        return value;
    }

    /**
     * 是否加入缓存
     * @return
     */
    private boolean isAddCache(String targetName, String methodName) {
        boolean flag = true;
        if (targetNamesList.contains(targetName)
                || methodNamesList.contains(methodName) || targetName.contains("$$EnhancerBySpringCGLIB$$")) {
            flag = false;
        }
        return flag;
    }

    /**
     * 创建缓存key
     * @param targetName
     * @param methodName
     * @param arguments
     */
    private String getCacheKey(String targetName, String methodName,
                               Object[] arguments) {
        StringBuffer sbu = new StringBuffer();
        sbu.append(targetName).append("_").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sbu.append("_").append(arguments[i]);
            }
        }
        return sbu.toString();
    }

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public void setTargetNamesList(List<String> targetNamesList) {
        this.targetNamesList = targetNamesList;
    }

    public void setMethodNamesList(List<String> methodNamesList) {
        this.methodNamesList = methodNamesList;
    }

    public void setDefaultCacheExpireTime(String defaultCacheExpireTime) {
        this.defaultCacheExpireTime = defaultCacheExpireTime;
    }
}
