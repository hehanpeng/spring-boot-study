package com.hehanpeng.springbootdemo.web;

import com.hehanpeng.springbootdemo.dto.Book;
import com.hehanpeng.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author hehanpeng
 * @date 2018/4/11 11:10
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
//    public String list(Model model) {
//    public String list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
    public String list(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable, Model model) {
//        List<Book> all = bookService.findAll();
//        model.addAttribute("books", all);

//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Page<Book> allByPage = bookService.findAllByPage(PageRequest.of(page, size,sort));

        Page<Book> allByPage = bookService.findAllByPage(pageable);
        model.addAttribute("books", allByPage);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book one = bookService.findOne(id);
        if (one == null) {
            one = new Book();
        }
        model.addAttribute("book", one);
        return "book";
    }

    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    @GetMapping("/books/input/{id}")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book one = bookService.findOne(id);
        model.addAttribute("book", one);
        return "input";
    }

    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        Book save = bookService.save(book);
        if (save != null) {
            attributes.addFlashAttribute("message", "《" + save.getName() + "》提交成功");
        }
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/delete")
    public String delete(@PathVariable long id, final RedirectAttributes attributes) {
        bookService.deleteOne(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/books";
    }

    /*
     * POST  ----> redirect ---> GET
     * */
}
