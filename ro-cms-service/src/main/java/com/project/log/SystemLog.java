package com.project.log;

import java.lang.annotation.*;

/**
 * @description 记录操作日志自定义注解
 * @author: huangh
 * @since 2019-09-02 15:16
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

	/** 模块名 */
	String module() default "";

	/** 操作方法名 */
	String methods() default "";
}
/*
	Retention注解

	Retention(保留)注解说明,这种类型的注解会被保留到那个阶段. 有三个值:
	1.RetentionPolicy.SOURCE —— 这种类型的Annotations只在源代码级别保留,编译时就会被忽略
	2.RetentionPolicy.CLASS —— 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略
	3.RetentionPolicy.RUNTIME —— 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
	下面示例中, @Retention(RetentionPolicy.RUNTIME)注解表明 Test_Retention注解将会由虚拟机保留,以便它可以在运行时通过反射读取.


	Documented 注解

	Documented 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的. 但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中.（个人观点：不是重点，了解即可。勿喷）


	Target注解

	@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
	作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
	取值(ElementType)有：

	1.CONSTRUCTOR:用于描述构造器
	2.FIELD:用于描述域
	3.LOCAL_VARIABLE:用于描述局部变量
	4.METHOD:用于描述方法
	5.PACKAGE:用于描述包
	6.PARAMETER:用于描述参数
	7.TYPE:用于描述类、接口(包括注解类型) 或enum声明

	Inherited 注解

	这是一个稍微复杂的注解类型. 它指明被注解的类会自动继承. 更具体地说,如果定义注解时使用了 @Inherited 标记,然后用定义的注解来标注另一个父类, 父类又有一个子类(subclass),则父类的所有属性将被继承到它的子类中.
*/
