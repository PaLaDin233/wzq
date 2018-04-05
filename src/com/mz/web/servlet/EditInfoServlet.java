/*package com.mz.web.servlet;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mz.service.Us2Services;
import com.mz.web.support.BaseServletSupport;
@WebServlet("/personal.html")
public class EditInfoServlet extends BaseServletSupport {

	private static final long serialVersionUID = 1L;
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
		HttpSession session=request.getSession();
		
		Map<String,String> map=services.searchPlayerInfo();
		
		session.setAttribute("userinfo", map);
		return "page/personalCenter.jsp";
	}

}
*/