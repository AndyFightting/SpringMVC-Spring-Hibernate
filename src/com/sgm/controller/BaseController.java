package com.sgm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import com.sgm.service.UserService;

//service 都放这里列出
public class BaseController {
	
	//用于api接口
	protected Map<String,Object> result = new HashMap<>();
	
	@Resource(name = "userService")
	protected UserService userService;

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	
}
