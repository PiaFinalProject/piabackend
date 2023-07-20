package com.teknokafalar.piabackend.denemeone;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.teknokafalar.piabackend.entities.Type;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToPostgreSQL {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/piabackend";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";

    public static void main(String[] args) {
        TypeDataImporter importer = new TypeDataImporter();
        importer.importData();
    }

    private static class TypeDataImporter {
        public void importData() {
            List<Type> typeList = readTypeDataFromExcel();

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String insertQuery = "INSERT INTO type_table (id, name) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    for (Type type : typeList) {
                        preparedStatement.setLong(1, type.getId());
                        preparedStatement.setString(2, type.getName());

                        preparedStatement.executeUpdate();
                    }
                }

                System.out.println("Type Sheet verileri PostgreSQL veritabanına aktarıldı.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private List<Type> readTypeDataFromExcel() {
            List<Type> typeList = new ArrayList<>();

            try {
                FileInputStream file = new FileInputStream("path/to/your/excel/file.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheet("Type"); // Sayfa adını "Type" olarak düzenledik

                Iterator<Row> rowIterator = sheet.iterator();

                // Skip header row
                if (rowIterator.hasNext()) {
                    rowIterator.next();
                }

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Type type = new Type();

                    type.setId((long) row.getCell(0).getNumericCellValue());
                    type.setName(getCellValue(row.getCell(1)));

                    typeList.add(type);
                }

                workbook.close();
                file.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return typeList;
        }

        private String getCellValue(Cell cell) {
            if (cell == null) {
                return "";
            }

            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue().trim();
                case NUMERIC:
                    return String.valueOf(cell.getNumericCellValue());
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                default:
                    return "";
            }
        }
    }
}
