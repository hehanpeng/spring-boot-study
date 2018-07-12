package com.hehanpeng.blog.service;

import com.hehanpeng.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author hehanpeng
 * @date 2018/5/22 10:09
 */
public interface TypeService {
    Type saveType(Type type);

    Type getType(long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}
