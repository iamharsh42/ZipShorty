package com.harsh.zipshorty.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private int clickCount = 0;
    private LocalDateTime createdDate;

    @ManyToOne // many-to-one relationship with users table
    @JoinColumn(name = "user_id")  // join
    private User user;

    @OneToMany(mappedBy = "urlMapping")  // one-to-many relationship with table clickevents
    private List<ClickEvent> clickEvents;

}
