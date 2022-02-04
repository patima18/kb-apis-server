package com.ehrd.kb.home.controller;

import com.ehrd.kb.home.model.SubjVO;
import com.ehrd.kb.home.service.SubjService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SubjController {

	@Autowired
	private SubjService subjService;

//	@Autowired
//	private RedisTemplate<String, String> redisTemplate;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@RequestMapping(value = {"/","/index"})
	public HashMap<String, Object> index(HttpServletRequest request, HttpServletResponse response) {
		SubjVO subjVO = new SubjVO();
		List<SubjVO> subjList = subjService.getSubjList(subjVO);

		logger.info("============= Fuck:" + subjList.size());

		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("subjList", subjList);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/list")
//	public HashMap<String, Object> list(HttpServletRequest request, HttpServletResponse response) {
	public HashMap<String, Object> list(@RequestBody SubjVO subjVO, HttpServletRequest request, HttpServletResponse response) {

//		HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
//		String key1 = "cd1";
//		String key2 = "cd2";
//
//		Map<String,String> cd1Map = new HashMap<String,String>();
//		cd1Map.put("10","하나");
//		cd1Map.put("20","두울");
//
////		hashOperations.put(key1, "10", "하나");
////		hashOperations.put(key1, "20", "두울");
//		hashOperations.putAll(key1, cd1Map);

//		Map<Object, Object> entries1 = hashOperations.entries(key1);
//		logger.info("============= FuckYeah:" + entries1.get("10") );
//		logger.info("============= FuckYeah:" + entries1.get("20") );




//		logger.info("============= FuckYeah:" + request.getParameter("subjCd") );
		logger.info("============= FuckYeah:" + subjVO.toString() );

		List<SubjVO> subjList = subjService.getSubjList(subjVO);

		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("result", subjList);
		return result;
	}
}