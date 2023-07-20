package com.teknokafalar.piabackend.entities;
import org.hibernate.annotations.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.TextType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","book"})
public class Author {
    @Id
    private Long id;


    private String firstName;
    private String lastName;
    private String images;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String about;

}
