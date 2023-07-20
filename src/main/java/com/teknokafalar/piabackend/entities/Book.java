package com.teknokafalar.piabackend.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String year;

    private String bookSummary;

    private String publisher;

    private String imagesUrl;

    private LocalDateTime addedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Type type;

}
