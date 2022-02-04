package com.ehrd.kb.noti.controller;

import com.ehrd.kb.noti.model.TmplVO;
import com.ehrd.kb.noti.service.TmplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
public class TmplController {

	@Autowired
	private TmplService tmplService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@RequestMapping(value = "/tmplList")
	public HashMap<String, Object> tmplList(@RequestBody TmplVO tmplVO, HttpServletRequest request, HttpServletResponse response) {

		logger.info("============= FuckYeah:" + tmplVO.toString() );

		List<TmplVO> tmplList = tmplService.getTmplList(tmplVO);

		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("result", tmplList);
		return result;
	}
}