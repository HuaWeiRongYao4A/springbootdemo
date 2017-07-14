package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Administrator on 2017/6/23.
 */
@Mapper
public interface HelloMapper {

    @Update("update hello set patent_type = #{patent_type} where patent_id = #{patent_id}")
    int update(@Param("patent_id") String patentId, @Param("patent_type") String patentType);
}
