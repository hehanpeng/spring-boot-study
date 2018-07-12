package com.hehanpeng.blog.service;

import com.hehanpeng.blog.dao.UserRepository;
import com.hehanpeng.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hehanpeng
 * @date 2018/5/16 16:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}
