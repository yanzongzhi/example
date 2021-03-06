/**
 * <p>Copyright:Copyright(c) 2016</p>
 * <p>Company:上海运图投资有限公司</p>
 * <p>包名:com.yuntu.common.http</p>
 * <p>文件名:BinaryBody.java</p>
 * <p>类更新历史信息</p>
 * @todo <a href="mailto:fankenie@yaomaiche.com">vernal(聂超)</a> 创建于 2016年3月8日 下午1:34:17
 */
package com.yzz.utils.http;

import org.springframework.util.Assert;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Description: 文件上传封装
 * @Author: yzz
 * @Date: 2018/8/8
 * modified By:
 */

public class BinaryBody implements Serializable{

	private static final long serialVersionUID = -8404803719838398735L;

	/**
	 * 属性名
	 */
	private String name;
	
	/**
	 * 二进制，支持File、byte[]、Inputsteam;
	 */
	private Object stream;
	
	private String fileName;
	
	public BinaryBody(String name,Object stream,String fileName){
		Assert.notNull(name,"name不能为空");
		Assert.notNull(stream,"stream不能为空");
		
		if(this.stream instanceof byte[] || this.stream instanceof InputStream){
			Assert.notNull(fileName,"fileName不能为空");
		}
		
		this.name = name;
		this.stream = stream;
		this.fileName = fileName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the stream
	 */
	public Object getStream() {
		return this.stream;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return this.fileName;
	}
	
}
