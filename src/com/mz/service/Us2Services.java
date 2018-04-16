package com.mz.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.mz.system.DBUtils;
import com.mz.web.support.PageBean;

public final class Us2Services {
	private Map<String, Object> dto=null;
	public Us2Services(Map<String,Object> dto) {
		this.dto=dto;
	}
	
	public Map<String,String> searchPlayerInfo()throws Exception{
		PreparedStatement pstm=null;
		ResultSet rs =null;
		
		try {
			StringBuilder sql= new StringBuilder()
			.append("select us201,us202,us203,us204,us205,us206,us207,us208,us209,us210,us211 from us2 ")
			.append("WHERE us210=? ");
			
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.setObject(1, this.dto.get("us101"));

			List<Map<String, String>> list=new ArrayList<Map<String,String>>();
			list=DBUtils.getListWithPstm(pstm);
			
			if(list.isEmpty())return null;
			else return list.get(0);
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
		
	}

	public boolean UpdatePlayerInfo()throws Exception {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			StringBuilder sql=new StringBuilder()
			.append("UPDATE `us2` SET ");
			Set<String> ks=dto.keySet();
			int i=0;
			for(String s:ks){
				if(i!=0)sql.append(" , "+s+"='"+dto.get(s)+"'");
				else sql.append(s+"='"+dto.get(s)+"'");
				i++;
			}
			sql.append(" WHERE (us201='"+dto.get("us201")+"')");
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.executeUpdate();
		} finally{
			DBUtils.close(pstm);
			DBUtils.close(rs);
		}
		
		return true;
	}

	public Map<String, String> searchPlayerInfoByPlayerId() throws Exception {
		PreparedStatement pstm=null;
		ResultSet rs =null;
		
		try {
			StringBuilder sql= new StringBuilder()
			.append("select us201,us202,us203,us204,us205,us206,us207,us208,us209,us210,us211 from us2 ")
			.append("WHERE us201=? ");
			
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.setObject(1, this.dto.get("us201"));

			List<Map<String, String>> list=new ArrayList<Map<String,String>>();
			list=DBUtils.getListWithPstm(pstm);
			
			if(list.isEmpty())return null;
			else return list.get(0);
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}

	public List<Map<String, String>> findByTriads() throws Exception {
		PreparedStatement pstm=null;
		ResultSet rs =null;
		
		try {
			StringBuilder sql= new StringBuilder()
			.append("select us201,us202,us203,us204,us205,us206,us207,us208,us209,us210,us211 from us2 ")
			.append("WHERE us210=? ")
			.append("or us201=? ")
			.append("or us202=? ");
			
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.setObject(1, this.dto.get("us210"));
			pstm.setObject(2, this.dto.get("us201"));
			pstm.setObject(3, this.dto.get("us202"));
			
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			
			list=DBUtils.getListWithPstm(pstm);
			
			return list;
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}

	 public void getAll(PageBean<Map<String,String>> pb) throws Exception {
	        
	        //2. 查询总记录数;  设置到pb对象中
	        int totalCount = this.getTotalCount();
	        pb.setTotalCount(totalCount);
	        
	        /*
	         * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
	         *              如果当前页为末页，再点下一页显示有问题！
	         * 解决：
	         *        1. 如果当前页 <= 0;       当前页设置当前页为1;
	         *        2. 如果当前页 > 最大页数；  当前页设置为最大页数
	         */
	        // 判断
	        if (pb.getCurrentPage() <=0) {
	            pb.setCurrentPage(1);                        // 把当前页设置为1
	        } else if (pb.getCurrentPage() > pb.getTotalPage()){
	            pb.setCurrentPage(pb.getTotalPage());        // 把当前页设置为最大页数
	        }
	        
	        //1. 获取当前页： 计算查询的起始行、返回的行数
	        int currentPage = pb.getCurrentPage();
	        int index = (currentPage -1 ) * pb.getPageCount();        // 查询的起始行
	        int count = pb.getPageCount();                            // 查询返回的行数
	        
	        
	        //3. 分页查询数据;  把查询到的数据设置到pb对象中
	        PreparedStatement pstm;
	        try {
	        	StringBuilder sql= new StringBuilder()
				.append("select us201,us202,us203,us204,us205,us206,us207,us208,us209,us210,us211 from us2 ")
				.append("WHERE us210=? ")
				.append("or us201=? ")
				.append("or us202=? ")
				.append("limit ? ,?");
				
				pstm=DBUtils.preparedStatement(sql.toString());
				pstm.setObject(1, this.dto.get("us210"));
				pstm.setObject(2, this.dto.get("us201"));
				pstm.setObject(3, this.dto.get("us202"));
	        	pstm.setObject(4, index);
	        	pstm.setObject(5, count);
				
				System.out.println("a"+pstm);
				
	            List<Map<String,String>> pageData = DBUtils.getListWithPstm(pstm);
	            // 设置到pb对象中
	            pb.setPageData(pageData);
	            
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	        
	    }
	
	 public int getTotalCount() throws Exception{
	        StringBuilder sql= new StringBuilder()
			.append("select count(*) from us2 ")
			.append("WHERE us210=? ")
			.append("or us201=? ")
			.append("or us202=? ");
	        PreparedStatement pstm=null;
	        try {
	        	pstm=DBUtils.preparedStatement(sql.toString());
	        	
	        	pstm.setObject(1, this.dto.get("us210"));
				pstm.setObject(2, this.dto.get("us201"));
				pstm.setObject(3, this.dto.get("us202"));
				
	        	ResultSet rs=null;
	        	
	        	
	        	
	        	rs=pstm.executeQuery();
	        	System.out.println(pstm);
	        	int count=0;
	        	if(rs.next()){
	        		count = Integer.parseInt(rs.getString(1));
		            
	        	}
	        	return count;
	            
	        }
	        finally{
	        	
	        }
	    }
	 
	 
	 
}
