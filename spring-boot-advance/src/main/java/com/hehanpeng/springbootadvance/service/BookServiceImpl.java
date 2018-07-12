package com.hehanpeng.springbootadvance.service;

import com.hehanpeng.springbootadvance.domain.Book;
import com.hehanpeng.springbootadvance.domain.BookRepository;
import com.hehanpeng.springbootadvance.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hehanpeng
 * @date 2018/4/24 11:04
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookId(Long id) {
        Book one = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("书单信息不存在"));
        return one;
    }
}
