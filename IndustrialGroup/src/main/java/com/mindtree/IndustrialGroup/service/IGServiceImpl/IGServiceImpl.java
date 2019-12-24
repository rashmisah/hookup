package com.mindtree.IndustrialGroup.service.IGServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.IndustrialGroup.entity.IG;
import com.mindtree.IndustrialGroup.repository.IGRepository;
import com.mindtree.IndustrialGroup.service.IGService;
@Service
public class IGServiceImpl implements IGService {

	@Autowired
	IGRepository igRepository;
	@Override
	public String addIg(IG ig) {
		igRepository.save(ig);
		return "success";
		
	}

}
