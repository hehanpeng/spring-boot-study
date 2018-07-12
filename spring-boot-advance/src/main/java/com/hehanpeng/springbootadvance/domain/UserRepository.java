package com.hehanpeng.springbootadvance.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hehanpeng
 * @date 2018/4/23 10:39
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
