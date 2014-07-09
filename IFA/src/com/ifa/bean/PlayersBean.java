package com.ifa.bean;

public class PlayersBean {

	private String name, teamCode;
	private int mPlayed, goals;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public int getmPlayed() {
		return mPlayed;
	}
	public void setmPlayed(int mPlayed) {
		this.mPlayed = mPlayed;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
}
