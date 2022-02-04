package com.ehrd.kb.comm.repository;

import com.ehrd.kb.comm.model.EmpVO;
import com.ehrd.kb.comm.model.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommRepository {

    List<EmpVO> selectEmpList(EmpVO empVO);
    List<MenuVO> selectMenuList(MenuVO menuVO);
}