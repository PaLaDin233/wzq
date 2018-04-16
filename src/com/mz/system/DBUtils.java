package com.mz.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.ThreadLocal;
public class DBUtils {
	private static String driver=
			"com.mysql.jdbc.Driver";
    private static String url=
    		"jdbc:mysql://localhost/wzq?characterEncoding=UTF8";
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    private DBUtils() {}
    static{
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    public static Connection getConnection()throws Exception {
		Connection conn=threadLocal.get();
		if(conn==null){
			conn=DriverManager.getConnection(url,"root","root");
			threadLocal.set(conn);
		}
		return conn;
	}
    public static void close(ResultSet rs) {
    	try {
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void close(PreparedStatement pstm){
    	try {
			if(pstm!=null){
				pstm.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }
    
    public static void close(){
    	try {
			Connection conn =threadLocal.get();
			if(conn!=null){
				threadLocal.remove();
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
    public static PreparedStatement preparedStatement(String sql)throws Exception{
    	return DBUtils.getConnection().prepareStatement(sql);
    }
    
    
    public static List<Map<String, String>> getListWithPstm(PreparedStatement pstm) 
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
					map.put(rsmd.getColumnLabel(i), rs.getString(i));
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
