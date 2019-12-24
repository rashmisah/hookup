package com.mindtree.IndustrialGroup.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	
	private String projectName;
	
	private int projectCost;
	
	@ManyToOne
	private Account account;

	public Project() {
		super();
	}

	public Project(int projectId, String projectName, int projectCost, Account account) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectCost = projectCost;
		this.account = account;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(int projectCost) {
		this.projectCost = projectCost;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
