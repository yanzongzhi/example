package com.yzz.action;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//demo
@RestController
@RequestMapping(value = "/test")
public class TestController {

	/**
	 * 注意:@RequestParam 支持post,get
	 * @RequestBody 只支持post
	 * 在eureka 注册中心中,微服务互相调用时候,如果参数是对象接收的,必须是post请求,
	 * 原因是eureka 自动将get请求转换为post请求
	 * @RequestParam 在微服务互相调用中,处理的时候必须带value
	 * */
	@RequestMapping(value = "test2" ,method = RequestMethod.GET)
    public Integer test(@RequestParam(value = "test") String test){
	    System.out.println(11);
	    return 1;
    }


}