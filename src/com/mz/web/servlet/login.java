package com.mz.web.servlet;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mz.web.support.BaseServletSupport;
@WebServlet("/GameOnline.html")
public class login extends BaseServletSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public login() {
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
		HttpSession session=request.getSession();
		Enumeration <String> sa=session.getAttributeNames();
		while (sa.hasMoreElements()) {  
			String name = sa.nextElement().toString();  
			Object value = session.getAttribute(name);
			
			System.out.println("<B>" + name + "</B>=" + value + "<br>");
			session.removeAttribute(name);
			System.out.println(session.getAttribute(name));
		}  
		return "page/login.jsp";
	}

}
