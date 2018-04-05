package com.mz.web.servlet;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mz.service.Us2Services;
import com.mz.web.support.BaseServletSupport;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

@WebServlet("/modinfo.html")
public class ModInfoServlet extends BaseServletSupport {

	public ModInfoServlet() {
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
		Us2Services services=new Us2Services(dto);
		services.UpdatePlayerInfo();
		
		Map<String, String> map=services.searchPlayerInfo();
		request.getSession().setAttribute("userinfo", map);
		
		return "page/personalCenter.jsp";
	}

}
