package com.icss.mapper;

import org.apache.ibatis.annotations.Param;

import com.icss.entity.User;

public interface IUserMapper {

	User login(@Param("name")String name, @Param("pwd")String pwd)throws Exception;

	String isValidUname(@Param("name")String name)throws Exception;

	int regist(User user)throws Exception;

}
