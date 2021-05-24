//package com.uol.products.controllers;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.uol.products.controller.ProductController;
//import com.uol.products.model.Product;
//import com.uol.products.service.ProductService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ProductControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    //@Test
//    public void testPostProductSucess() throws Exception {
//
//        Product product = new Product("Iphone 12", "Celular Iphone 12", 8000D);
//        Mockito.when(productService.save(product)).thenReturn(product);
//        this.mockMvc.perform(post("/v1/products/", product)
//                .contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }
//
//    //@Test
//    public void testPostProductFailWithNullName() throws Exception {
//        Product product = new Product(null, "Celular Iphone 12", 8000D);
//        Mockito.when(productService.save(product)).thenReturn(product);
//        this.mockMvc.perform(post("/v1/products/", product)
//                .contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//
//    }
//
//    //@Test
//    public void testPostProductFailWithNullDescription() throws Exception {
//        Product product = new Product("Iphone 12", null, 8000D);
//        Mockito.when(productService.save(product)).thenReturn(product);
//        this.mockMvc.perform(post("/v1/products/", product)
//                .contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//    //@Test
//    public void testPostProductFailWithNullPrice() throws Exception {
//        Product product = new Product("Iphone 12", "Celular Iphone 12", null);
//        Mockito.when(productService.save(product)).thenReturn(product);
//        this.mockMvc.perform(post("/v1/products/", product)
//                .contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//    @Test
//    public void testPostProductFailWithNegativePrice() throws Exception {
//        Product product = new Product("Iphone 12", "Celular Iphone 12", -80000D);
//        Mockito.when(productService.save(product)).thenReturn(product);
//        this.mockMvc.perform(post("/v1/products/", product)
//                .contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//}