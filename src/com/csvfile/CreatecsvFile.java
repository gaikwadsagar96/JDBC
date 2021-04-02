package com.csvfile;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreatecsvFile 
{

	public static void main(String[] args) 
	{
		try {
			PrintWriter pw=new PrintWriter(new File("C:\\Users\\microbyte\\Desktop\\csv\\camping.csv"));
			StringBuilder sb=new StringBuilder();
			Connection connection=null;
			ConnectionDb connectionDb=new ConnectionDb();
			connection=connectionDb.getConnection();
			ResultSet rs=null;
			String sql="Select * from camping where bdate='2021-03-20'";
			PreparedStatement ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			int id=1;
			while(rs.next()) {
				sb.append(id++);
				sb.append(",");
				sb.append(rs.getString("name"));
				sb.append(",");
				sb.append(rs.getString("veg"));
				sb.append(",");
				sb.append(rs.getString("nonveg"));
				sb.append(",");
				sb.append(rs.getString("totalpersons"));
				sb.append(",");
				sb.append(rs.getString("mobile"));
				sb.append(",");
				sb.append(rs.getString("bdate"));
				sb.append(",");
				sb.append(rs.getString("email"));
				sb.append("\r\n");
			}
			pw.write(sb.toString());
			pw.close();
			System.out.println("finished");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
