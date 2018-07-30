package com.yzz.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:数据源配置注解
 *
 * @Author: yzz
 * @Date: 2018/7/29
 * modified By:
 */
/**@Retention 默认有三种策略供选择
 * source :被编译器忽略
 * class :默认行为,运行时不会被jvm保留
 * runtime 保留在运行时,可以通过反射区获取注解信息
 */
/**@Target Annotation所修饰的对象范围
        1.CONSTRUCTOR:用于描述构造器
　　　　2.FIELD:用于描述域
　　　　3.LOCAL_VARIABLE:用于描述局部变量
　　　　4.METHOD:用于描述方法
　　　　5.PACKAGE:用于描述包
　　　　6.PARAMETER:用于描述参数
　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
    String value();
}
