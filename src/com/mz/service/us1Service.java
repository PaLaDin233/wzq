package com.mz.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mz.system.DBUtils;

public final class us1Service {
	private Map<String,Object> dto=null;
	
	public us1Service(Map<String,Object> dto){
		this.dto=dto;
	}
	
	public Map<String,String> SearchUse()throws Exception{
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			StringBuilder sql=new StringBuilder()
			.append("SELECT us101,us102,us103,us104,us105 from us1 ")
			.append("where us105='01' and us102=? ")
			;
			pstm=DBUtils.preparedStatement(sql.toString());
			pstm.setObject(1, this.dto.get("us102"));
			rs=pstm.executeQuery();
			Map<String,String> map=null;
			if(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int count=rsmd.getColumnCount();
				int initSize=((int)(count/.75))+1;
				
				map=new HashMap<>(initSize);
				for(int i=1;i<=count;i++){
					map.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
			}
			return map;
		}
		finally{
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}

	public boolean UpdatePassword() throws Exception {
		// TODO Auto-generated method stub
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
