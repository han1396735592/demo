package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.MessageDao;
import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Service;

/**
* Message(Message)表服务实现类
*
* @author han xinjian
* @since 2020-05-27 22:19:54
*/
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {

}