package com.mz.web.servlet;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.awt.RepaintArea;

import com.mz.service.us1Service;
import com.mz.web.support.BaseServletSupport;
@WebServlet("/login.html")
public class loginServlet extends BaseServletSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public loginServlet() {
	}

	protected boolean nextPageMethod() throws Exception {
		return false;
	}

	protected String execute(Map<String, Object> dto,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		boolean success=false;
		us1Service services=new us1Service(dto);
		Map<String,String> map=services.SearchUse();
		HttpSession session=request.getSession();
		
		if(map==null){
			String msg="用户名不存在";
			session.setAttribute("msg", msg);
			return "page/login.jsp";
		}
		success=(map.get("us103").toString().equals(dto.get("us103").toString()));
		if (success) {
			String msg="登录成功";
			session.setAttribute("msg", msg);
			return "page/homepage.jsp";
		} else {
			String msg="密码错误";
			session.setAttribute("msg", msg);
			return "page/login.jsp";
		}
	}

}
