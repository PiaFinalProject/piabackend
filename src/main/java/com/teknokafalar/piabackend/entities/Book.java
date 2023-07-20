package com.teknokafalar.piabackend.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = true)
    private Author author;

    @Lob
    @org.hibernate.annotations.Type(type = "org.hibernate.type.TextType")
    private String bookSummary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId", nullable = true)
    private Type type;
    private String year;
    private String imagesUrl;

    private double stock;

    private double price;
    private String publisher;
    private LocalDateTime addedDate;




}
