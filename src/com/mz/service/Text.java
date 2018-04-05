package com.mz.service;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mz.system.DBUtils;

public class Text {

	public Text() {
		PreparedStatement pstm=null;
		Map<String,String> dto=new HashMap<String, String>();
		
		dto.put("", "a1");
		dto.put("b", "b2");
		dto.put("c", "c3");
		
		
		
		try {
			StringBuilder sql=new StringBuilder()
			.append("UPDATE `us2` SET 1");
			Set<String> ks=dto.keySet();
			for(String s:ks){
				sql.append(" , "+s+"='"+dto.get(s)+"'");
			}
			sql.append(" WHERE (us201='1')");
			System.out.println(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
}
