package com.hehanpeng.springbootadvance.web;

import com.hehanpeng.springbootadvance.domain.User;
import com.hehanpeng.springbootadvance.domain.UserRepository;
import com.hehanpeng.springbootadvance.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author hehanpeng
 * @date 2018/4/23 10:40
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String registerPost(@Valid UserForm userForm, BindingResult result) {
        if (!userForm.confirmPassword()) {
            result.rejectValue("confirmPassword", "confirmError", "两次密码不一致");
        }
        if (result.hasErrors()) {
            return "register";
        }
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            for (FieldError error : fieldErrors) {
//                System.out.println(error.getField() + " : " + error.getDefaultMessage() + " : " + error.getCode());
//            }
//        }

//        User user = convertFor(userForm);
//        User user = new UserFormConvert().convert(userForm);
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/exception")
    public String textException() {
        throw new RuntimeException("测试异常处理");
    }

    @Deprecated
    private User convertFor(UserForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return user;
    }
}
