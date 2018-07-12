package com.hehanpeng.springbootdemo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Hello controler.
 *
 * @author hehanpeng
 * @date 2018 /4/9 11:56
 */
//@Controller
@RestController
@RequestMapping("/v2")
public class HelloController {

    @Value("${book.name}}")
    private String bookname;
    @Value("${book.author}}")
    private String author;
    @Value("${book.isbn}")
    private String isbn;
    @Value("${book.description}")
    private String description;

//    @Autowired
//    private Book bookbean;

    @RequestMapping(value = "/say", method = RequestMethod.DELETE)
//    @RequestMapping(value = "/say")/*支持全请求模式*/
//    @PostMapping("/say")
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/books")
    @ResponseBody/*该注解可以自动转换类型，map 会自动转换成json格式*/
    public Map<String, Object> getAll(@RequestParam int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        System.out.println(">>>" + page + ">>>");
        System.out.println(">>>" + size + ">>>");
        Map<String, Object> book = new HashMap<>();
        book.put("name", "天龙八部");
        book.put("isbn", "0900000000");
        book.put("author", "金庸");

        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "时间简史");
        book2.put("isbn", "0900000001");
        book2.put("author", "霍金");

        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("size", size);
        pageMap.put("content", contents);

//        return "books";
//        return book;
        return pageMap;
    }


    /**
     * 正则表达式：{参数名:正则表达式}.
     *
     * @param tid      the tid
     * @param username the username
     * @return the one
     */
    @GetMapping("/books/{id}/{username:[a-z_]+}")
    public Object getOne(@PathVariable("id") long tid, @PathVariable String username) {
        System.out.println(">>>" + tid + ">>>");
        System.out.println(">>>" + username + ">>>");
        Map<String, Object> book = new HashMap<>();
//        book.put("name", "天龙八部");
//        book.put("isbn", "0900000000");
//        book.put("author", "金庸");
//        book.put("username", username);
//        book.put("id", tid);

//        book.put("name", bookname);
//        book.put("isbn", isbn);
//        book.put("author", author);
//        book.put("description", description);
        return null;
    }

    @PostMapping("/books")
    public Object post(@RequestParam String name, @RequestParam String author, @RequestParam long isbn) {
        Map<String, Object> book = new HashMap<>();
        book.put("name", name);
        book.put("isbn", isbn);
        book.put("author", author);
        return book;
    }
}
