package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Message;
import org.apache.ibatis.annotations.Mapper;
/**
* Message(Message)表数据库访问层
*
* @author han xinjian
* @since 2020-05-27 22:19:53
*/
@Mapper
public interface MessageDao extends BaseMapper<Message> {

}