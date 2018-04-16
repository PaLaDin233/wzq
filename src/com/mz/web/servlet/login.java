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
		
	}

	@Override
	protected boolean nextPageMethod() throws Exception {
		
		return false;
	}

	@Override
	protected String execute(Map<String, Object> dto,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session=request.getSession();
		Enumeration <String> sa=session.getAttributeNames();
		while (sa.hasMoreElements()) {  
			String name = sa.nextElement().toString();  
			//Object value = session.getAttribute(name);
			
			session.removeAttribute(name);
		}  
		return "page/login.jsp";
	}

}
