package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.entities.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BooksExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"id", "name", "author", "bookSummary", "type", "year", "images", "stock", "price"};
    static String SHEET = "Books";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Book> excelToBooks(InputStream is) {
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
                            //   book.(currentCell.getStringCellValue());
                            break;

                        case 3:
                            // author.setAbout((currentCell.getStringCellValue()));
                            break;

                        case 4:
                            //author.setImages((currentCell.getStringCellValue()));
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                //authors.add(author);
            }

            workbook.close();

            //return authors;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
        return null;
    }
}
