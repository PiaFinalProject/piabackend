package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.repository.AuthorRepository;
import com.teknokafalar.piabackend.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class ExcelService {
    @Autowired
    AuthorRepository repository;

    @Autowired
    TypeRepository typeRepository;

    public void saveAuthors(MultipartFile file) {
        try {
            List<Author> authors = AuthorExcelHelper.excelToTutorials(file.getInputStream());
//                    .stream().filter(author -> author.getId() != null
//                    || author.getFirstName() != null
//                                    || author.getLastName() != null
//                    ).collect(Collectors.toList());
            repository.saveAll(authors);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public void saveTypes(MultipartFile file) {
        try {
            List<Type> types = TypeExcelHelper.excelToTutorials(file.getInputStream());
//                    .stream().filter(author -> author.getId() != null
//                    || author.getFirstName() != null
//                                    || author.getLastName() != null
//                    ).collect(Collectors.toList());
            typeRepository.saveAll(types);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }


}