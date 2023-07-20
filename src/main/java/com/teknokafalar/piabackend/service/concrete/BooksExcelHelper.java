package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
import com.teknokafalar.piabackend.service.abstracts.TypeService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BooksExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"id", "name", "authorId", "bookSummary", "typeId", "year", "imagesUrl", "stock", "price","publisher"};
    static String SHEET = "Books";

    private final AuthorService authorService;
    private final TypeService typeService;
    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public  List<Book> excelToBooks(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Book> books = new ArrayList<Book>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Book book = new Book();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            book.setId((long) currentCell.getNumericCellValue());
                            break;

                        case 1:
                            book.setName(currentCell.getStringCellValue());
                            break;

                        case 2:
                            Author authorById = authorService.getAuthorById((long) currentCell.getNumericCellValue());
                            book.setAuthor(authorById);
                            break;

                        case 3:
                            book.setBookSummary(currentCell.getStringCellValue());
                            // author.setAbout((currentCell.getStringCellValue()));
                            break;

                        case 4:
                            //type
                            Type typeById = typeService.getTypeById((long) currentCell.getNumericCellValue());
                            book.setType(typeById);
                            break;

                        case 5:
                            //year
                            book.setYear(String.valueOf(currentCell.getNumericCellValue()));
                            break;

                        case 6:
                            //imagesurl
                            book.setImagesUrl(currentCell.getStringCellValue());
                            break;
                        case 7:
                            //STOCK
                            book.setStock(currentCell.getNumericCellValue());
                            break;
                        case 8:
                            //price
                            book.setPrice(currentCell.getNumericCellValue());
                            break;
                        case 9:
                            //price
                            book.setPublisher(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                //authors.add(author);
                books.add(book);
            }

            workbook.close();

            return books;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
