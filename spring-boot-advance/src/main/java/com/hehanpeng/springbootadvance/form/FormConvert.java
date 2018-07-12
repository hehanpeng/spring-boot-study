package com.hehanpeng.springbootadvance.form;

/**
 * @author hehanpeng
 * @date 2018/4/23 16:22
 */
public interface FormConvert<S, T> {
    T convert(S s);
}
