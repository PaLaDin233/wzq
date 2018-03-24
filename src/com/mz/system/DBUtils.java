package com.mz.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
