package com.demo.model;

public class Skill {
     private int skid;
     private String skname;
     private int experience;
	public Skill() {
		super();
	}
	public Skill(int skid, String skname, int experience) {
		super();
		this.skid = skid;
		this.skname = skname;
		this.experience = experience;
	}
	public int getSkid() {
		return skid;
	}
	public void setSkid(int skid) {
		this.skid = skid;
	}
	public String getSkname() {
		return skname;
	}
	public void setSkname(String skname) {
		this.skname = skname;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Skill [skid=" + skid + ", skname=" + skname + ", experience=" + experience + "]";
	}
     
}
