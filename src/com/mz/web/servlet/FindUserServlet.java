package com.mz.web.servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mz.service.Us2Services;
import com.mz.web.support.BaseServletSupport;
import com.mz.web.support.PageBean;

@WebServlet("/userList.html")
public class FindUserServlet extends BaseServletSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FindUserServlet() {
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
		
		/*Us2Services services=new Us2Services(dto);
		List<Map<String,String>> list=services.findByTriads();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("userlist", list);
		
		return "page/findUser.jsp";*/
		
		
		
		try {
            //1. 获取“当前页”参数；  (第一次访问当前页为null) 
            String currPage = request.getParameter("currentPage");
            // 判断
            if (currPage == null || "".equals(currPage.trim())){
                currPage = "1";      // 第一次访问，设置当前页为1;
            }
            // 转换
            int currentPage = Integer.parseInt(currPage);
            
            int pageNum=1;//每页数据列数
            
            //2. 创建PageBean对象，设置当前页参数； 传入service方法参数
            PageBean<Map<String,String>> pageBean = new PageBean<Map<String,String>>(pageNum);
            pageBean.setCurrentPage(currentPage);
            
            //3. 调用service  
            Us2Services services=new Us2Services(dto);
            services.getAll(pageBean);    // 【pageBean已经被dao填充了数据】
            
          //  System.out.println(pageBean.getPageData());
            //4. 保存pageBean对象，到request域中
            request.setAttribute("pageBean", pageBean);
            
            HttpSession session=request.getSession();
            session.setAttribute("us210", dto.get("us210"));
            session.setAttribute("us201", dto.get("us201"));
            session.setAttribute("us202", dto.get("us202"));
            
            //5. 跳转 
            return "page/findUser.jsp";
        } catch (Exception e) {
            e.printStackTrace();  // 测试使用
            // 出现错误，跳转到错误页面；给用户友好提示
            return "page/error.jsp";
        }
	}

}
