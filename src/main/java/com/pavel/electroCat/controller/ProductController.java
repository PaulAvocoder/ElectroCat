package com.pavel.electroCat.controller;

import com.pavel.electroCat.model.Product;
import com.pavel.electroCat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("index");
        List<Product> allProducts = productService.findAll();
        model.addObject("list", allProducts);
        return model;
    }

    @PostMapping("/product/search")
    ModelAndView findAll(Product searchCriteria) {
        ModelAndView model = new ModelAndView("index");
        List<Product> result = productService.findBySearchCriteria(searchCriteria);
        model.addObject("list", result);
        return model;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    ModelAndView addNewProduct(@ModelAttribute("addProduct") Product newProduct) {
        productService.saveOrUpdate(newProduct, null);
        return home();
    }

    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.POST)
    ModelAndView updateProduct(@ModelAttribute("editProduct") Product newProduct, @PathVariable("id") Long id) {
        productService.saveOrUpdate(newProduct, id);
        return home();
    }

    @RequestMapping("/product/delete")
    ModelAndView deleteProduct(@RequestParam String productId) {
        productService.deleteProduct(Long.valueOf(productId));
        return home();
    }

    @RequestMapping(value = "/product/edit")
    ModelAndView editProduct(@RequestParam String productId) {
        ModelAndView model = new ModelAndView("edit");
        Product product = productService.findOneProductId(Long.valueOf(productId));
        model.addObject("product", product);
        return model;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    ModelAndView addProduct() {
        ModelAndView model = new ModelAndView("addProduct");
        return model;
    }
}
