package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * ProductController
 *
 * @author liuyong
 * @version 1.0
 * @description com.controller
 * @date 2022/6/25 16:03
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/show")
    public String select(Integer id , Model model)
    {
        Product product = productService.findProductById(id);
        model.addAttribute("product" , product);

        return "show";
    }
}
