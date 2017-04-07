package cn.dxq.demo;

import java.util.ResourceBundle;

public class PropertiesTest {
    public static void main(String[] args) {
		//读取资源文件 
    	ResourceBundle jdbcInfo = ResourceBundle.getBundle("JDBC");
		 
    	//获取资源文件中的信息
    	String driver = jdbcInfo.getString("driverclass");
    	String url = jdbcInfo.getString("url");
    	String username = jdbcInfo.getString("username");
        String password = jdbcInfo.getString("password");
    	
        //输出信息
        System.out.println("驱动程序为："+driver);
        System.out.println("URL为："+url);
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
		 
	}
}
