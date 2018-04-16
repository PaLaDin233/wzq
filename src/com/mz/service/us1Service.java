package com.mz.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import com.mz.system.DBUtils;

public final class us1Service {
	private Map<String,Object> dto=null;
	
	public us1Service(Map<String,Object> dto){
		this.dto=dto;
	}
	
	/**
	 * @author PaLaDin_
	 * @return 用户表中的用户信息
	 * @throws Exception
	 * @功能 根据用户编号从用户表中获得满足要求的用户信息
	 */
	@SuppressWarnings("null")
	public Map<String,String> SearchUse()throws Exception{
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//编译SQL语句
			StringBuilder sql=new StringBuilder()
			.append("SELECT us101,us102,us103,us104,us105 from us1 ")
			.append("where us105='01' and us102=? ")
			;
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.setObject(1, this.dto.get("us102"));
			
			//从数据库从查出需要的数据,得到数据列表
			
			List<Map<String,String>> list=null;
			
			list=DBUtils.getListWithPstm(pstm);
			
			//有数据返回列表第一个，否则返回空
			if(list!=null||!list.isEmpty())return list.get(0);
			else return null;
			
		}
		finally{
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}

	/**
	 * @author PaLaDin_
	 * @return 是否成功修改密码
	 * @throws Exception
	 * @功能 修改用户密码
	 */
	public boolean UpdatePassword() throws Exception {

		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			StringBuilder sql=new StringBuilder()
			.append("UPDATE us1 SET us103=?")
			.append(" WHERE us101 = ?");
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.setObject(1, this.dto.get("newus103"));
			pstm.setObject(2, this.dto.get("us101"));
			
			return pstm.executeUpdate()>0;
		} finally{
			DBUtils.close(pstm);
			DBUtils.close(rs);
		}
	}
	 
	/**
	 * @author PaLaDin_
	 * @return
	 * @throws Exception
	 * @功能根据用户流水号查询用户信息
	 */
	
	public Map<String, String> SearchUserById() throws Exception {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			StringBuilder sql=new StringBuilder()
			.append("SELECT us101,us102,us103,us104,us105 from us1 ")
			.append("where us105='01' and us101=? ")
			;
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.setObject(1, this.dto.get("us101"));
			
			rs=pstm.executeQuery();
			
			List<Map<String, String>> list=null;
			list=DBUtils.getListWithPstm(pstm);
			
			if(list.isEmpty())return null;
			else return list.get(0);
			/*Map<String,String> map=null;
			if(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int count=rsmd.getColumnCount();
				int initSize=((int)(count/.75))+1;
				
				map=new HashMap<>(initSize);
				for(int i=1;i<=count;i++){
					map.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
			}
			return map;*/
		}
		finally{
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}
}
