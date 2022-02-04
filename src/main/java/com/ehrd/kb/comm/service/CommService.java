package com.ehrd.kb.comm.service;

import com.ehrd.kb.comm.model.EmpVO;
import com.ehrd.kb.comm.model.MenuVO;
import com.ehrd.kb.comm.repository.CommRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommService {
	
	private final CommRepository commRepository;
	
	public List<EmpVO> getSubjList(EmpVO empVO){
			return commRepository.selectEmpList(empVO);
	}

	public List<MenuVO> getMenuList(MenuVO menuVO){
			return commRepository.selectMenuList(menuVO);
	}

	public List<MenuVO> getDeptTreeAllList(MenuVO menuVO){
		List<MenuVO> items = getMenuList(menuVO);
		if(items == null) items = new ArrayList<>();


		return null;
	}
}