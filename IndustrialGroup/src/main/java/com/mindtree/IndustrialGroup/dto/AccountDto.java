package com.mindtree.IndustrialGroup.dto;

public class AccountDto {
	private int accountId;
	private String accountName;
	private int accountRevenue;
	public AccountDto() {
		super();
	}
	public AccountDto(int accountId, String accountName, int accountRevenue) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountRevenue = accountRevenue;
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
	
}
