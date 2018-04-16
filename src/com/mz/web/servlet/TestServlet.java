package com.mz.web.servlet;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mz.service.Text;
import com.mz.web.support.BaseServletSupport;

@WebServlet("/t")
public class TestServlet extends BaseServletSupport {

	public TestServlet() {
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
		//Text text=new Text();
		System.out.println(dto.get("test").toString());
		request.getSession().setAttribute("test", dto.get("test").toString());
		return "page/NewFile.jsp";
	}

}
