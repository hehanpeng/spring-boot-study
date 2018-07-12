package com.hehanpeng.springbootdemo.web;

import com.hehanpeng.springbootdemo.dto.Book;
import com.hehanpeng.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * @author hehanpeng
 * @date 2018/4/11 11:10
 */
@RestController
@RequestMapping("/api/v1")
public class BookApp {

    @Autowired
    private BookService bookService;

    /**
     * 获取读书清单列表
     *
     * @return
     */
    @GetMapping("/books")
//    public List<Book> getAll() {
    public Page<Book> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
//        return bookService.findAll();
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookService.findAllByPage(PageRequest.of(page, size, sort));
    }

    /**
     * 新增一个书单
     *
     * @return
     */
    @PostMapping("/books")
    public Book post(Book book) {
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
//        book.setIsbn(Long.toString(book.getId()));
        return bookService.save(book);
    }

    /**
     * 获取一个书单
     *
     * @return
     */
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    /**
     * 更新一个书单
     *
     * @return
     */
    @PutMapping("/books")
    public Book update(@RequestParam long id, @RequestParam String name, @RequestParam String author, @RequestParam String description, @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
        return bookService.save(book);
    }

    /**
     * 删除一条书单
     *
     * @param id
     */
    @DeleteMapping("/books/{id}")
    public void update(@PathVariable long id) {
        bookService.deleteOne(id);
    }

    @PostMapping("/books/by")
    public int findBy(@RequestParam String author, @RequestParam int status, @RequestParam String des, @RequestParam int len, @RequestParam long id, @RequestParam long uid) {
//        return bookService.findByAuthor(author);
//        return bookService.findByAuthorAndStatus(author, status);
//        return bookService.findByDescriptionEndsWith(des);
//        return bookService.findByJPQL(len);
//        return bookService.updateByJPQL(status, id);
//        return bookService.deleteByJPQL(id);
        return bookService.deleteAndUpdate(id, status, uid);
    }
}
