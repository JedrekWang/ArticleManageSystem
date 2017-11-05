package com.jedrek.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jedrek.bean.User;
import com.jedrek.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {
    private Logger log = LoggerFactory.getLogger(UserService.class);
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    public int deleteUser(String username) {
        return userMapper.deleteUser(username);
    }

    public int updateUserPassword(String username, String password) {
        return userMapper.updateUserPassword(username, password);
    }

    public User queryUser(Integer userId) {
        return userMapper.queryUser(userId);
    }

    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    public int queryDegreeByName(String username) {
        return userMapper.queryDegreeByName(username);
    }

    public List<User> queryUsers() {
        List<User> users = userMapper.queryUsers();
        return users;
    }

}
