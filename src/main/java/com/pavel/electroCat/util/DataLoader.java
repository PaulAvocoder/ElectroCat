package com.pavel.electroCat.util;

import com.pavel.electroCat.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoader {
    public List<Product> loadProduct(String fileName) throws IOException {
        List<Product> result = new ArrayList<>();
        File file = ResourceUtils.getFile("classpath:" + fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            // Read first line
            String line = br.readLine();
            // Make sure file has correct headers
            if (line == null) throw new IllegalArgumentException("File is empty");

            if (!line.equals("Name,Discript,Price,Img,Category,Date,Status"))
                throw new IllegalArgumentException("File has wrong columns: " + line);


            while ((line = br.readLine()) != null) {

                String[] items = line.split(",");
                try {
                    if (items.length > 7) throw new ArrayIndexOutOfBoundsException();
                    Product product = new Product();

                    product.setName(String.valueOf(items[0]));
                    product.setDescription(String.valueOf(items[1]));
                    product.setPrice(Integer.valueOf(items[2]));
                    product.setImg(String.valueOf(items[3]));
                    product.setCategory(String.valueOf(items[4]));

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    Date entryDate = Date.valueOf(LocalDate.parse(items[5], formatter));

                    product.setEntryDate(entryDate);
                    product.setStatus(Boolean.valueOf(items[6]));

                    result.add(product);
                } catch (Exception e) {
                    System.out.println("Invalid Record Found: " + line);
                }
            }
            return result;
        } finally {
            br.close();
        }
    }

}