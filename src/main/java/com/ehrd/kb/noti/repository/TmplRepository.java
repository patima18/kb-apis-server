package com.ehrd.kb.noti.repository;

import com.ehrd.kb.noti.model.TmplVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TmplRepository {
 
    List<TmplVO> selectTmplList(TmplVO tmplVO);
    
}