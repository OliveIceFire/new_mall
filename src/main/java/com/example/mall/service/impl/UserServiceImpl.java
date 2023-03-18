package com.example.mall.service.impl;

import com.example.mall.exception.MallException;
import com.example.mall.exception.MallExceptionEnum;
import com.example.mall.model.dao.UserMapper;
import com.example.mall.model.entity.User;
import com.example.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public void register(String username, String password) throws MallException {
        User user = userMapper.selectByName(username);
        if (user!=null) {
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int count = userMapper.insertSelective(user);
        if (count == 0){
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }
}
