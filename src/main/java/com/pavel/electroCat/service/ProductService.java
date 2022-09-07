package com.pavel.electroCat.service;

import com.pavel.electroCat.dao.ProductRepository;
import com.pavel.electroCat.errorHandler.ProductNotFoundException;
import com.pavel.electroCat.model.Product;
import com.pavel.electroCat.util.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService implements IService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private DataLoader dataLoader;

    private Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Override
    public List<Product> findAll() {
        List<Product> result = repository.findAll();
        return result;
    }

    public Product addNewProduct(Product newProduct) {
        return repository.save(newProduct);
    }

    public Product findOneProductId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> findBySearchCriteria(Product searchCriteria) {


        List<Product> result = findAll();
        if (searchCriteria.getName() == null
                && searchCriteria.getCategory() == null
                && searchCriteria.getPrice() == null)
            return result;

        HashMap<Long, Product> productHashMap = new HashMap<>();
        System.out.println("search Criteria" + searchCriteria);
        if (searchCriteria.getName() != null && !searchCriteria.getName().isEmpty()) {
            repository
                    .findByNameContainingIgnoreCase(searchCriteria.getName())
                    .forEach(s -> productHashMap.put(s.getProductId(), s));

        } else if (searchCriteria.getCategory() != null) {
            result.stream()
                    .filter(a -> a.getCategory().equals(searchCriteria.getCategory()))
                    .forEach(s -> productHashMap.put(s.getProductId(), s));

        } else if (searchCriteria.getPrice() != null) {
            result.stream()
                    .filter(a -> a.getPrice().equals(searchCriteria.getPrice()))
                    .forEach(s -> productHashMap.put(s.getProductId(), s));
        }
        return new ArrayList<Product>(productHashMap.values());
    }



    public Product saveOrUpdate(Product newProduct, Long id) {
        if (null != id) {
            Product product = repository.getOne(id);
            if (product != null) {
                product.setName(newProduct.getName());
                product.setDescription(newProduct.getDescription());
                product.setPrice(newProduct.getPrice());
                product.setImg(newProduct.getImg());
                product.setEntryDate(newProduct.getEntryDate());
                product.setStatus(newProduct.getStatus());
                return repository.save(product);
            }
        }
        return repository.save(newProduct);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public void loadInitialDataFromFile(String fileName) {
        try {
            List<Product> products = dataLoader.loadProduct(fileName);
            products.stream().peek(s -> System.out.println("saving" + s)).forEach(s -> repository.save(s));
        } catch (Exception ex) {
            logger.error("Could not load the product in system: " + ex.getMessage());
        }
    }


}
