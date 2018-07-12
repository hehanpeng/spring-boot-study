package com.hehanpeng.blog.service;

import com.hehanpeng.blog.pojo.User;

/**
 * @author hehanpeng
 * @date 2018/5/16 16:58
 */
public interface UserService {
    User checkUser(String username,String password);
}
