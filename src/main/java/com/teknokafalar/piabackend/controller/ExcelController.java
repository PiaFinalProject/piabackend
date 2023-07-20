package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.dto.response.ResponseMessage;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
import com.teknokafalar.piabackend.service.abstracts.BookService;
import com.teknokafalar.piabackend.service.concrete.AuthorExcelHelper;
import com.teknokafalar.piabackend.service.concrete.BooksExcelHelper;
import com.teknokafalar.piabackend.service.concrete.ExcelService;
import com.teknokafalar.piabackend.service.concrete.TypeExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin("*")
@Controller
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    ExcelService fileService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (TypeExcelHelper.hasExcelFormat(file)) {
            try {
   //   fileService.saveAuthors(file);
    //fileService.saveTypes(file);
        fileService.saveBooks(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<Author>> getAllAuthors() {
        try {
            List<Author> authors = authorService.getAuthor();

            if (authors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(authors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}