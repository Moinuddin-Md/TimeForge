package com.employee.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class TimeInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private int eid;
	private String outtime;
	private String intime="Not in yet";
	private String totaltime="Not applicable";
	private LocalDate date;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TimeInfo [tid=" + tid + ", eid=" + eid + ", outtime=" + outtime + ", intime=" + intime + ", totaltime="
				+ totaltime + ", date=" + date + "]";
	}
	
}
