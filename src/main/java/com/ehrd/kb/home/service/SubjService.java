package com.ehrd.kb.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehrd.kb.home.model.SubjVO;
import com.ehrd.kb.home.repository.SubjRepository;

@Service
public class SubjService {
	
	@Autowired 
	private SubjRepository subjRepository;
	
	public List<SubjVO> getSubjList(SubjVO subjVO){
			return subjRepository.selectSubjList(subjVO);
	}
}