package com.cn.mapper;

import com.cn.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author tao_wc
 * @date 2018/1/19
 */
@Mapper
public interface PersonMapper {

    @Select("select * from person where id=#{id}")
    Person findOne(@Param("id") Long id);
}
