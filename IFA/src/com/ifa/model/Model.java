package com.ifa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ifa.bean.*;
import com.ifa.dao.Dao;

public class Model {

	private ResultSet rs;
	private Dao dao=new Dao();
	private boolean flag;
	
	public ArrayList<TeamsBean> selectTeam(){
		ArrayList<TeamsBean> teamsList=new ArrayList<TeamsBean>();
		rs=dao.selectTeam();
		
		try{
			while(rs.next()){
				TeamsBean tb=new TeamsBean();
				
				tb.setTeamName(rs.getString(1));
				tb.setTeamCode(rs.getString(2));
				tb.setmPlayed(rs.getInt(3));
				tb.setmWon(rs.getInt(4));
				tb.setmLost(rs.getInt(5));
				tb.setmTie(rs.getInt(6));
				teamsList.add(tb);
			}
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return teamsList;
	}
	
	public ArrayList<PlayersBean> selectPlayers(String teamCode){
		ArrayList<PlayersBean> playersList=new ArrayList<PlayersBean>();
		rs=dao.selectPlayers(teamCode);
		try{
			while(rs.next()){
				PlayersBean tb=new PlayersBean();
				
				tb.setName(rs.getString(1));
				tb.setTeamCode(rs.getString(2));
				tb.setmPlayed(rs.getInt(3));
				tb.setGoals(rs.getInt(4));
				playersList.add(tb);
			}
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return playersList;
	}

	public ArrayList<MatchesBean> prevMatches() {
		ArrayList<MatchesBean> prevMatches=new ArrayList<MatchesBean>();
		rs=dao.prevMatches();
		try{
			while(rs.next()){
				MatchesBean tb=new MatchesBean();
				
				tb.setTeamA(rs.getString(1));
				tb.setTeamB(rs.getString(2));
				tb.setResult(rs.getString(3));
				tb.setLocation(rs.getString(4));
				tb.setDate(null);
				prevMatches.add(tb);
			}
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return prevMatches;
	}

	public ArrayList<MatchesBean> nextMatches() {
		ArrayList<MatchesBean> nextMatches=new ArrayList<MatchesBean>();
		rs=dao.nextMatches();
		try{
			while(rs.next()){
				MatchesBean tb=new MatchesBean();
				tb.setTeamA(rs.getString(1));
				tb.setTeamB(rs.getString(2));
				tb.setDate(rs.getDate(3));
				tb.setLocation(rs.getString(4));
				tb.setResult("0-0");
				nextMatches.add(tb);
			}
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return nextMatches;
	}
	
	public boolean insertTeam(String teamName,String teamCode,int mPlayed,int mWon,int mLost,int mTie){
		flag=dao.insertTeam(teamName, teamCode, mPlayed, mWon, mLost, mTie);
		return flag;
	}
	
	public boolean updateTeam(String teamName,String teamCode,int mPlayed,int mWon,int mLost,int mTie){
		flag=dao.updateTeam(teamName, teamCode, mPlayed, mWon, mLost, mTie);
		return flag;
	}
	
	public boolean deleteTeam(String teamCode){
		flag=dao.deleteTeam(teamCode);
		return flag;
	}
	
	public boolean insertPlayer(String playerName, String teamCode,	int mPlayed, int goals) {
		flag=dao.insertPlayer(playerName, teamCode, mPlayed, goals);
		return flag;
	}
	
	public boolean deletePlayer(String name){
		flag=dao.deletePlayer(name);
		return flag;
	}
	
	public boolean updatePlayer(String playerName, String teamCode,	int mPlayed, int goals){
		flag=dao.updatePlayer(playerName, teamCode, mPlayed, goals);
		return flag;
	}
	
	public boolean insertMatch(String teamA, String teamB, String date, String location){
		String result="0-0";
		flag=dao.insertMatch(teamA, teamB, date, location, result);
		return flag;
	}
	
	public boolean updateMatch(String teamA, String teamB, String result){
		flag=dao.updateMatch(teamA, teamB, result);
		return flag;
	}
	
	public boolean deleteMatch(String teamA, String teamB){
		flag=dao.deleteMatch(teamA, teamB);
		return flag;
	}
	
	public TeamsBean selectOneTeam(String teamCode){
		rs=dao.selectTeam(teamCode);
		TeamsBean tb=new TeamsBean();
		try {
			rs.next();
			tb.setTeamName(rs.getString(1));
			tb.setTeamCode(rs.getString(2));
			tb.setmPlayed(rs.getInt(3));
			tb.setmWon(rs.getInt(4));
			tb.setmLost(rs.getInt(5));
			tb.setmTie(rs.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tb;
	}
	
	public int checkPassword(String username, String password){
		int flag=0;											//flag default value 0
		String originalPassword=null;
		
		rs=dao.getPassword(username);
		try{
			if(rs.next()){									//userID with the chosen privilege exists
				originalPassword=rs.getString(1);
				if(password.equals(originalPassword)){		//password matches
					flag=1;
				}else{
					flag=-1;								//password mismatch
				}
			}else{
				flag=-2;									//userID with the chosen privilege NOT found
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
		
		return flag;
	}

	public ArrayList<PlayersBean> selectPlayers() {
		ArrayList<PlayersBean> playersList=new ArrayList<PlayersBean>();
		rs=dao.selectPlayers();
		
		try{
			while(rs.next()){
				PlayersBean tb=new PlayersBean();
				
				tb.setName(rs.getString(1));
				tb.setTeamCode(rs.getString(2));
				tb.setmPlayed(rs.getInt(3));
				tb.setGoals(rs.getInt(4));
				playersList.add(tb);
			}
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return playersList;
	}

	public ArrayList<MatchesBean> selectMatches() {
		ArrayList<MatchesBean> matchesList=new ArrayList<MatchesBean>();
		rs=dao.selectMatches();
		
		try{
			while(rs.next()){
				MatchesBean tb=new MatchesBean();
				
				tb.setTeamA(rs.getString(1));
				tb.setTeamB(rs.getString(2));
				matchesList.add(tb);
			}
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return matchesList;
	}

}
