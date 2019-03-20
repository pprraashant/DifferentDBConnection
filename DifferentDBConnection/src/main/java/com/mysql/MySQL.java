package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.getenv();
		Class.forName("com.hamysql.cj.jdbc.Driver");
		Connection db=null;
		db= DriverManager.getConnection("jdbc:mysql://PAWARP02V:3306/online", "onlineTest","Online@2019");
		//System.out.println(db.getSchema()); //added in java 8
		System.out.println(db.isClosed());
		Statement st=db.createStatement();
		ResultSet rs=st.executeQuery("show tables;");
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}

		//ResultSet rs1=st.executeQuery("insert into users values('Prashant');");
		//if(st.execute("insert into users(uname,password_p) values('Prashant','');"))
			//System.out.println("success");
		
		
		ResultSet rs1=st.executeQuery("select * from users;");
		while(rs1.next())
		{
			System.out.println(rs1.getString(1));
			System.out.println(rs1.getString(2));
		}
		db.close();
		
	}

}
