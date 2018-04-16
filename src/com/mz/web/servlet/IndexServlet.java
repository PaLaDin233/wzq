package com.mz.web.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mz.service.Us2Services;
import com.mz.web.support.BaseServletSupport;
import com.mz.web.support.PageBean;

public class IndexServlet extends BaseServletSupport {

	public IndexServlet() {
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
		try {
            //1. 获取“当前页”参数；  (第一次访问当前页为null) 
            String currPage = request.getParameter("currentPage");
            // 判断
            if (currPage == null || "".equals(currPage.trim())){
                currPage = "1";      // 第一次访问，设置当前页为1;
            }
            // 转换
            int currentPage = Integer.parseInt(currPage);
            
            //2. 创建PageBean对象，设置当前页参数； 传入service方法参数
            PageBean<Map<String,String>> pageBean = new PageBean<Map<String,String>>();
            pageBean.setCurrentPage(currentPage);
            
            //3. 调用service  
            Us2Services services=new Us2Services(dto);
            services.getAll(pageBean);    // 【pageBean已经被dao填充了数据】
            
            //4. 保存pageBean对象，到request域中
            request.setAttribute("pageBean", pageBean);
            
            //5. 跳转 
            return "page/userlist.jsp";
        } catch (Exception e) {
            e.printStackTrace();  // 测试使用
            // 出现错误，跳转到错误页面；给用户友好提示
            return "page/error.jsp";
        }
	}

}
