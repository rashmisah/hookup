package com.mindtree.IndustrialGroup.IgController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.IndustrialGroup.dto.AccountDto;
import com.mindtree.IndustrialGroup.entity.Account;
import com.mindtree.IndustrialGroup.entity.IG;
import com.mindtree.IndustrialGroup.exception.IgControllerServiceException;
import com.mindtree.IndustrialGroup.service.AccountService;
import com.mindtree.IndustrialGroup.service.IGService;
import com.mindtree.IndustrialGroup.service.ProjectService;

@RestController
public class IndustrialGroupController {

	@Autowired
	IGService igService;
	@Autowired
	AccountService accountService;
	@Autowired
	ProjectService projectService;

	@PostMapping("/addIg")
	public String addIg(@RequestBody IG ig) {
		String response = igService.addIg(ig);
		return response;
	}

	@PostMapping("/addAccount&Project")
	public String addAccountAndProject(@RequestBody Account account) throws IgControllerServiceException {
		String response = accountService.addAccountAndProject(account);
		return response;
	}

	@GetMapping("/assignAccountToIg/{IgId}/{accountId}")
	public String assignAccount(@PathVariable int IgId, @PathVariable int accountId)
			throws IgControllerServiceException {
		String response = accountService.assignAcounts(IgId, accountId);
		return response;
	}

	@GetMapping("/getAccounts/{IgId}")
	public List<AccountDto> assignAccount(@PathVariable int IgId) throws IgControllerServiceException {
		List<AccountDto> list = accountService.getAcounts(IgId);
		return list;
	}

}
