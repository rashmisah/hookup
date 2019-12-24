package com.mindtree.IndustrialGroup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.IndustrialGroup.dto.AccountDto;
import com.mindtree.IndustrialGroup.entity.Account;
import com.mindtree.IndustrialGroup.exception.IgControllerServiceException;

@Service
public interface AccountService {

	public String addAccountAndProject(Account account) throws IgControllerServiceException;

	public String assignAcounts(int igId, int accountId) throws IgControllerServiceException;

	public List<AccountDto> getAcounts(int igId) throws IgControllerServiceException;

}
