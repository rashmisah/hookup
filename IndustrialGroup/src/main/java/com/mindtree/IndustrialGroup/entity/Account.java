package com.mindtree.IndustrialGroup.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account implements Comparable<Account> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	private String accountName;
	private int accountRevenue;

	@ManyToOne
	private IG ig;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private List<Project> projects;

	public Account() {
		super();
	}

	public Account(int accountId, String accountName, int accountRevenue, IG ig, List<Project> projects) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountRevenue = accountRevenue;
		this.ig = ig;
		this.projects = projects;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountRevenue() {
		return accountRevenue;
	}

	public void setAccountRevenue(int accountRevenue) {
		this.accountRevenue = accountRevenue;
	}

	public IG getIg() {
		return ig;
	}

	public void setIg(IG ig) {
		this.ig = ig;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int compareTo(Account other) {
		int result = other.getAccountRevenue() - this.getAccountRevenue();
		if (result == 0) {
			result = other.getAccountName().compareToIgnoreCase(this.getAccountName());
		}
		return result;
	}

}
