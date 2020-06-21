package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
* User(User)表服务实现类
*
* @author han xinjian
* @since 2020-05-27 22:19:54
*/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}