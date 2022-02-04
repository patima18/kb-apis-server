package com.ehrd.kb.comm.controller;

import com.ehrd.kb.comm.model.EmpVO;
import com.ehrd.kb.comm.model.MenuVO;
import com.ehrd.kb.comm.service.CommService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommController {

	private final CommService commService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@RequestMapping(value = "/popEmpList")
	public ResponseEntity<List<EmpVO>> popEmpList(@RequestBody EmpVO empVO, HttpServletRequest request, HttpServletResponse response) {

		logger.info("============= FuckEmp:" + empVO.toString() );

		HashMap<String, Object> result = new HashMap<String, Object>();
		List<EmpVO> rtnList = commService.getSubjList(empVO);

		return ResponseEntity.ok().body(rtnList);
	}

	@ResponseBody
	@PostMapping(value = "/api/menuList")
	public ResponseEntity<List<MenuVO>> getMenuList(@RequestBody MenuVO menuVO, HttpServletRequest request, HttpServletResponse response) {

		logger.info("============= FuckMenu:" + menuVO.toString() );

		HashMap<String, Object> result = new HashMap<String, Object>();
		List<MenuVO> rtnList = commService.getMenuList(menuVO);

		return ResponseEntity.ok().body(rtnList);
	}
}