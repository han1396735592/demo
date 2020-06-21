package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
/**
* User(User)表数据库访问层
*
* @author han xinjian
* @since 2020-05-27 22:19:54
*/
@Mapper
public interface UserDao extends BaseMapper<User> {

}