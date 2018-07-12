package com.hehanpeng.springbootadvance.form;

import com.hehanpeng.springbootadvance.domain.User;
import org.springframework.beans.BeanUtils;

/**
 * @author hehanpeng
 * @date 2018/4/23 16:23
 */
public class UserFormConvert implements FormConvert<UserForm, User> {
    @Override
    public User convert(UserForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return user;
    }
}
