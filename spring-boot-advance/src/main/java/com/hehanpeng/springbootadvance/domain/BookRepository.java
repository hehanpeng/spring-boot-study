package com.hehanpeng.springbootadvance.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hehanpeng
 * @date 2018/4/24 11:02
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
