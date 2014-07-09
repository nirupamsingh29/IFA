package com.ifa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class Dao {
	private ResultSet rs;
	private Connection con=DBConnector.getDBConnector();
	private PreparedStatement ps;
	private boolean flag;
	
	public ResultSet getPassword(String username){
		try {
			ps=con.prepareStatement("SELECT password FROM admin WHERE username=?;");
			ps.setString(1, username);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectAdmin(String username){
		try{
		ps = con.prepareStatement("SELECT * from admin WHERE username=?;");
		ps.setString(1, username);
		rs=ps.executeQuery();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectTeam(){
		try{
		ps = con.prepareStatement("SELECT * from teams;");
		rs=ps.executeQuery();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectPlayers(String teamCode){
		try{
		ps = con.prepareStatement("SELECT * from players WHERE t_code=?;");
		ps.setString(1, teamCode);
		rs=ps.executeQuery();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return rs;
	}


	public ResultSet prevMatches() {
		try{
			ps = con.prepareStatement("SELECT team_A, team_B, result, location from matches WHERE date<curdate();");
			rs=ps.executeQuery();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return rs;
	}


	public ResultSet nextMatches() {
		try{
			ps = con.prepareStatement("SELECT team_A, team_B, date, location from matches WHERE date>curdate();");
			rs=ps.executeQuery();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return rs;
	}

	public boolean insertTeam(String teamName, String teamCode, int mPlayed, int mWon, int mLost, int mTie) {
		try {
			ps = con.prepareStatement("INSERT INTO teams VALUES(?,?,?,?,?,?)");
			ps.setString(1,teamName );
			ps.setString(2, teamCode);
			ps.setInt(3, mPlayed);
			ps.setInt(4, mWon);
			ps.setInt(5, mLost);
			ps.setInt(6, mTie);
			flag=!ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	public boolean updateTeam(String teamName, String teamCode, int mPlayed, int mWon, int mLost, int mTie) {
		try{
			ps = con.prepareStatement("UPDATE teams SET t_name=?,m_played=?,m_won=?,m_lost=?,m_tie=? WHERE t_code=?;");
			ps.setString(1,teamName );
			ps.setInt(2, mPlayed);
			ps.setInt(3, mWon);
			ps.setInt(4, mLost);
			ps.setInt(5, mTie);
			ps.setString(6, teamCode);
			flag=!ps.execute();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return flag;
	}

	public boolean deleteTeam(String teamCode){
		
		try{
			ps = con.prepareStatement("DELETE FROM players WHERE t_code=?;");
			ps.setString(1, teamCode);
			ps.execute();
			ps = con.prepareStatement("DELETE FROM matches WHERE team_A=? or team_B=?;");
			ps.setString(1, teamCode);
			ps.setString(2, teamCode);
			ps.execute();
			ps=con.prepareStatement("DELETE FROM teams WHERE t_code=?;");
			ps.setString(1, teamCode);
			flag=!ps.execute();
			
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return flag;
	}
	
	public ResultSet selectTeam(String teamCode){
		
		try{
			ps = con.prepareStatement("SELECT * from teams WHERE t_code=?;");
			ps.setString(1, teamCode);
			
			rs=ps.executeQuery();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return rs;
	}

	public ResultSet selectPlayers() {
		try{
			ps = con.prepareStatement("SELECT * from players;");
			rs=ps.executeQuery();
			} catch(SQLException sql){
				sql.printStackTrace();
			}
			return rs;
	}

	public ResultSet selectMatches() {
		try{
			ps = con.prepareStatement("SELECT team_A, team_B from matches;");
			rs=ps.executeQuery();
			} catch(SQLException sql){
				sql.printStackTrace();
			}
			return rs;
	}

	public boolean insertPlayer(String playerName, String teamCode,	int mPlayed, int goals) {
		try {
			ps = con.prepareStatement("INSERT INTO players VALUES(?,?,?,?,?,?)");
			ps.setString(1,playerName );
			ps.setString(2, teamCode);
			ps.setInt(3, mPlayed);
			ps.setInt(4, goals);
			flag=!ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deletePlayer(String name) {
		try {
			ps = con.prepareStatement("DELETE FROM players WHERE name=?");
			ps.setString(1,name );
			flag=!ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updatePlayer(String playerName, String teamCode,	int mPlayed, int goals) {
		try{
			ps = con.prepareStatement("UPDATE players SET t_code=?, m_played=?, goals=? WHERE p_name=?;");
			ps.setString(1,teamCode );
			ps.setInt(2, mPlayed);
			ps.setInt(3, goals);
			ps.setString(4, playerName);
			flag=!ps.execute();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return flag;
	}

	public boolean insertMatch(String teamA, String teamB, String date,	String location, String result) {
		try {
			ps = con.prepareStatement("INSERT INTO matches VALUES(?,?,?,?,?)");
			ps.setString(1,teamA );
			ps.setString(2, teamB);
			ps.setString(3, date);
			ps.setString(4, location);
			ps.setString(5, result);
			flag=!ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateMatch(String teamA, String teamB, String result) {
		try{
			ps = con.prepareStatement("UPDATE matches SET result=? WHERE team_A=? AND team_B=?;");
			ps.setString(1,result );
			ps.setString(2, teamA);
			ps.setString(3, teamB);
			flag=!ps.execute();
		} catch(SQLException sql){
			sql.printStackTrace();
		}
		return flag;
	}

	public boolean deleteMatch(String teamA, String teamB) {
		try {
			ps = con.prepareStatement("DELETE FROM matches WHERE team_A=? AND team_B=?;");
			ps.setString(1, teamA);
			ps.setString(2, teamB);
			flag=!ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
