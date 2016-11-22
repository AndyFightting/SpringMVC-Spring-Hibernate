package com.sgm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sgm.entity.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/user/getAllUser";
	}

	// GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
	@RequestMapping(value = "/getAllUser", method = { RequestMethod.GET })
	public String getAllUser(HttpServletRequest request, ModelMap model) {

		// request.setAttribute("userList", userService.getAllUser());
		// model.put("userList", userService.getAllUser());

		HttpSession session = request.getSession();
		session.setAttribute("userList", userService.getAllUser());

		return "/index";
	}

	@RequestMapping("/getUser")
	public String getUser(int id, HttpServletRequest request) {
		request.setAttribute("user", userService.getUser(id));
		return "/editUser";
	}

	@RequestMapping("/delUser")
	public void delUser(int id, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (userService.delUser(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {
		userService.updateUser(user);
		user = userService.getUser(user.getId());
		request.setAttribute("user", user);
		return "redirect:/user/getAllUser";
	}

	@RequestMapping("/userListApi")
	@ResponseBody
	public Map<String, Object> getUserListApi() {
		result.put("msg", "hello wrold");
		result.put("list", userService.getAllUser());
		return result;
	}
}
