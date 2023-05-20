package com.russellsite.russellsite.learning.contentcalendar.model;

import java.time.LocalDateTime;

public class Content {

    private Integer id;
    private String title;
    private String description;
    private Status status;
    private Type contentType;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String url;

    public Content(Integer id, String title, String description,
                   Status status, Type contentType, LocalDateTime dateCreated,
                   LocalDateTime dateUpdated, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.contentType = contentType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.url = url;
    }

    public Content() {}

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Type getContentType() {
        return contentType;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public String getUrl() {
        return url;
    }
}
