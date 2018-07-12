package com.hehanpeng.springbootdemo.dao;

import com.hehanpeng.springbootdemo.dto.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hehanpeng
 * @date 2018/4/11 11:07
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    @Transactional(readOnly = true)
    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

    List<Book> findByDescriptionEndsWith(String des);

    // nativeQuery = true 开启sql查询
    //    @Query("select b from Book b where length(b.author) > ?1")
    @Query(value = "select * from book where length(author) > ?1", nativeQuery = true)
    List<Book> findByJPQL(int len);

    @Modifying
    @Transactional
    @Query("update Book b set b.status=?1 where b.id=?2")
    int updateByJPQL(int status, long id);

    @Modifying
    @Transactional
    @Query("delete from Book  b where b.id=?1")
    int deleteByJPQL(long id);
}
