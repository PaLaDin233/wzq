package com.mz.web.servlet;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mz.service.us1Service;
import com.mz.web.support.BaseServletSupport;
@WebServlet("/ModPassword.html")
public class ModPasswordServlet extends BaseServletSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModPasswordServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean nextPageMethod() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String execute(Map<String, Object> dto,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		us1Service services=new us1Service(dto);
		Map<String,String> map=services.SearchUserById();
		HttpSession session=request.getSession();
		
		//System.out.println(map);
		if(map.get("us103").toString().equals(dto.get("us103").toString())){
			if(services.UpdatePassword())
			session.setAttribute("msg", "修改成功");
			else session.setAttribute("msg", "修改失败");
			return "page/error.jsp";
		}
		else {
			session.setAttribute("msg", "密码错误");
			return "page/error.jsp";
		}
	}

}
