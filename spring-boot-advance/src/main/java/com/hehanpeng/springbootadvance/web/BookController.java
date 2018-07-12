package com.hehanpeng.springbootadvance.web;

import com.hehanpeng.springbootadvance.domain.Book;
import com.hehanpeng.springbootadvance.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hehanpeng
 * @date 2018/4/24 11:06
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookId(id);
        model.addAttribute("book", book);
        return "book";
    }

    /**
     * 异常处理
     *
     * @param request
     * @param e
     * @return
     */
//    @ExceptionHandler({Exception.class})
//    public ModelAndView handlerException(HttpServletRequest request, Exception e) throws Exception {
//        logger.error("Request URL : {} ，Exception : {}", request.getRequestURL(), e.getMessage());
//        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
//            throw e;
//        }
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("url", request.getRequestURL());
//        mav.addObject("exception", e);
//        mav.setViewName("error/error");
//        return mav;
//    }
}
