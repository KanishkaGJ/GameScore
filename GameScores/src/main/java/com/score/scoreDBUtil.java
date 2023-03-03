package com.score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class scoreDBUtil {
	
	public static List<highScore> findScore(int UID){
		
		ArrayList<highScore> hs = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/GameScores";
		String user ="root";
		String pass = "kanishka";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select max(score) from Score group by '"+UID+"'";
			ResultSet rSet = stmt.executeQuery(sql); 
			
			if(rSet.next()) {
				int uid =  rSet.getInt(2);
				int score = rSet.getInt(4);
				int gid = rSet.getInt(3);
				
				highScore hsDetails = new highScore(uid, gid, score);
				
				hs.add(hsDetails);
				
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return hs;
		
	}
	
	public static boolean insertScore(int uid,int gid, int score) {
		
		boolean isSuccess = false;
		
		String url = "jdbc:mysql://localhost:3306/GameScores";
		String user ="root";
		String pass = "kanishka";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO score VALUES (0, '"+uid+"','"+gid+"'.'"+score+"')";
			int rSet = stmt.executeUpdate(sql); 
			
			if(rSet > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	

}
	

