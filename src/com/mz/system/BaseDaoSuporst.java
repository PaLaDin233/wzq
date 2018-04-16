package com.mz.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDaoSuporst {

	
	
	protected BaseDaoSuporst(String string) {
		// TODO Auto-generated constructor stub
	}

	protected void select() throws Exception{
		try {
			
		} 
		finally{
			
		}
	}
	
	//根据dto从对应的数据库中取出数据包装为list返回
	protected List<Map<String, String>> getListWithPstm(PreparedStatement pstm) 
			throws Exception {
		
		ResultSet rs=null;
		
		try {
			
			rs=pstm.executeQuery();
			
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			while(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int count=rsmd.getColumnCount();
				int initSize=((int)(count/.75))+1;				
				
				Map<String,String> map=null;
				map=new HashMap<>(initSize);
				for(int i=1;i<=count;i++){
					map.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
				list.add(map);
			}
			return list;
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}
}
