package com.russellsite.russellsite.contentcalendar.repository;

import com.russellsite.russellsite.contentcalendar.model.Content;
import com.russellsite.russellsite.contentcalendar.model.Status;
import com.russellsite.russellsite.contentcalendar.model.Type;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void save(Content newContent) {
        content.removeIf(c -> c.getId().equals(newContent.getId()));
        content.add(newContent);
    }

    @PostConstruct
    public void init() {
        Content contentInit = new Content(
            1,
            "My First Blog Post",
            "This is Russell's first blog post",
            Status.IDEA,
            Type.ARTICLE,
            LocalDateTime.now(),
            null,
            "");

        if (content.isEmpty()) {
            content.add(contentInit);
        }

    }

    public boolean existsById(Integer id) {
        return content.stream().filter(c -> c.getId().equals(id)).count() != 0;
    }

    public void deleteContent(Integer id) {
        content.removeIf(c -> c.getId().equals(id));
    }
}
