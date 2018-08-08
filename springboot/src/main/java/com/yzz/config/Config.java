package com.yzz.config;

/**
 * @Author yzz
 * @Date 10:20 2018/8/7
 */ 
public interface Config {

    /**
     * 根据key 获取配置
     * @param key
     * @return
     */
    String v(String key);

    /**
     * 根据 key 获取 number 类型的配置配置
     * @param key
     * @param numberClass
     * @param <T>
     * @return
     */
    <T extends Number> T v(String key, Class<T> numberClass);

    /**
     * 执行表达式
     * @param expression
     * @return
     */
    Object execute(String expression);

    /**
     * 排序字段
     * @return
     */
    int getOrder();
}
