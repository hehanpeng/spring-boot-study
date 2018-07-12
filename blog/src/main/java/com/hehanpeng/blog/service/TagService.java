package com.hehanpeng.blog.service;

import com.hehanpeng.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author hehanpeng
 * @date 2018/5/22 10:09
 */
public interface TagService {
    Tag saveTag(Tag Tag);

    Tag getTag(long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    Tag updateTag(Long id, Tag Tag);

    void deleteTag(Long id);
}
