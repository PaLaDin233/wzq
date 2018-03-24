package com.mz.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

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
			.append("SELECT us102,us103,us104,us105 from us1 ")
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
}
