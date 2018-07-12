package com.hehanpeng.blog.dao;

import com.hehanpeng.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hehanpeng
 * @date 2018/5/16 17:00
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
