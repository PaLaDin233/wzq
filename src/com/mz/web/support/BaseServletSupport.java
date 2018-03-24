package com.mz.web.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class BaseServletSupport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toPath=null;
		boolean nextPageMothed=false;
		try {
			Map<String,Object> dto=this.createDto(request);
			toPath=this.execute(dto,request,response);
			nextPageMothed=this.nextPageMethod();
		} catch (Exception e) {
			request.setAttribute("msg", "网络故障");
			e.printStackTrace();
			// TODO: handle exception
		}
		String path=request.getContextPath();
		if(nextPageMothed)response.sendRedirect(path+"/"+toPath);//页面重定向，允许跳转到互联网的任意页面
		else request.getRequestDispatcher("/"+toPath).forward(request, response);//服务器内部跳转
	}
	protected abstract boolean nextPageMethod()throws Exception;

	protected abstract String execute(Map<String, Object> dto, 
			HttpServletRequest request,HttpServletResponse response)throws Exception;
	private Map<String, Object> createDto(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, String[]> tem=request.getParameterMap();
		Map<String,Object> dto=new HashMap<String, Object>();
		Set<Entry<String,String[]>> entrySet=tem.entrySet();
		for(Entry<String,String[]> entry:entrySet){
			if(entry.getValue().length==1){
				dto.put(entry.getKey(), entry.getValue()[0]);
			}
			else{
				dto.put(entry.getKey(), entry.getValue());
			}
		}
		return dto;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
