package com.mindtree.IndustrialGroup.service.AccountServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.IndustrialGroup.dto.AccountDto;
import com.mindtree.IndustrialGroup.entity.Account;
import com.mindtree.IndustrialGroup.entity.IG;
import com.mindtree.IndustrialGroup.entity.Project;
import com.mindtree.IndustrialGroup.exception.AccountRevenueExceedsException;
import com.mindtree.IndustrialGroup.exception.IGNotFoundException;
import com.mindtree.IndustrialGroup.exception.IgControllerServiceException;
import com.mindtree.IndustrialGroup.exception.NoAccountFoundException;
import com.mindtree.IndustrialGroup.repository.AccountRepository;
import com.mindtree.IndustrialGroup.repository.IGRepository;
import com.mindtree.IndustrialGroup.repository.ProjectRepository;
import com.mindtree.IndustrialGroup.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	IGRepository igRepository;

	@Override
	public String addAccountAndProject(Account account) throws IgControllerServiceException {
		int pcost = 0;
		List<Project> projects = account.getProjects();
		for (Project project : projects) {
			pcost = pcost + project.getProjectCost();
		}
		if (pcost > account.getAccountRevenue())
			throw new AccountRevenueExceedsException("Sorry! project Cost is high");
		else {
			for (Project project : projects) {
				project.setAccount(account);
			}
			account.setProjects(projects);
			accountRepository.save(account);
			return "success";
		}

	}

	@Override
	public String assignAcounts(int igId, int accountId) throws IgControllerServiceException {
		List<IG> igs = igRepository.findAll();
		List<Account> accounts = accountRepository.findAll();
		IG ig = igs.stream().filter(i -> i.getIgId() == igId).findAny()
				.orElseThrow(() -> new IGNotFoundException("No IG found"));
		Account account = accounts.stream().filter(i -> i.getAccountId() == accountId).findAny()
				.orElseThrow(() -> new NoAccountFoundException("No Account found"));

		List<Account> accountlist = ig.getAccounts();
		if (accountlist.size() == 0) {
			account.setIg(ig);
			ig.setAccounts(accountlist);
			igRepository.saveAndFlush(ig);
		} else {
			accountlist.add(account);
			for (Account account2 : accountlist) {
				account.setIg(ig);
			}
			ig.setAccounts(accountlist);
			igRepository.saveAndFlush(ig);
		}
		return null;
	}

	private AccountDto convertEntityToDto(Account i) {
		return modelMapper.map(i, AccountDto.class);
	}

	@Override
	public List<AccountDto> getAcounts(int igId) throws IgControllerServiceException {
		List<IG> igs = igRepository.findAll();
		IG ig = igs.stream().filter(i -> i.getIgId() == igId).findAny()
				.orElseThrow(() -> new IGNotFoundException("No IG found"));
		List<Account> accounts = ig.getAccounts();
		Collections.sort(accounts);
		List<AccountDto> list = accounts.stream().map(i -> convertEntityToDto(i)).collect(Collectors.toList());
		return list;
	}

}
