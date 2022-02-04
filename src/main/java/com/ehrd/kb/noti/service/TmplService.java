package com.ehrd.kb.noti.service;

import com.ehrd.kb.noti.model.TmplVO;
import com.ehrd.kb.noti.repository.TmplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmplService {
	
	@Autowired 
	private TmplRepository tmplRepository;
	
	public List<TmplVO> getTmplList(TmplVO tmplVO){
			return tmplRepository.selectTmplList(tmplVO);
	}
}