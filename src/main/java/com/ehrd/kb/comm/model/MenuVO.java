package com.ehrd.kb.comm.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuVO {
	private String menuId;
	private String menuNm;
	private String parentId;
	private String menuUrl;
	private String menuOrdr;
	private String menuLvl;

	private List<MenuVO> childMenu = new ArrayList<MenuVO>();
}