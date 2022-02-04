package com.ehrd.kb.home.repository;
 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ehrd.kb.home.model.SubjVO;
 
@Repository
@Mapper
public interface SubjRepository {
 
    List<SubjVO> selectSubjList(SubjVO subjVO);
    
}