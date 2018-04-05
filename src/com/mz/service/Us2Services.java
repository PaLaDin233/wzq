package com.mz.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.mz.system.DBUtils;

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

			Map<String,String> map=null;
			
			rs=pstm.executeQuery();
			if(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int count=rsmd.getColumnCount();
				int initSize=((int)(count/.75))+1;
				
				map=new HashMap<>(initSize);
				for(int i=1;i<count;i++){
					map.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
				
			}
			return map;
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
			System.out.println(sql);
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

			Map<String,String> map=null;
			
			rs=pstm.executeQuery();
			if(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int count=rsmd.getColumnCount();
				int initSize=((int)(count/.75))+1;
				
				map=new HashMap<>(initSize);
				for(int i=1;i<count;i++){
					map.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
				
			}
			return map;
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}
}
