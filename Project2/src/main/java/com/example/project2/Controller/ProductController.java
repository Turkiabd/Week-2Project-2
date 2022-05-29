package com.example.project2.Controller;


import com.example.project2.Service.ProductService;
import com.example.project2.model.Api;
import com.example.project2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public ResponseEntity<ArrayList<Product>> getProduct(){
        return ResponseEntity.status(200).body(productService.getProduct());
    }


    @PostMapping
    public ResponseEntity<Api> addProduct(@RequestBody @Valid Product product , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage() , 400));
        }
        Boolean isProductAdded = productService.addProduct(product);
        if(!isProductAdded ){

            return ResponseEntity.status(500).body(new Api("error adding a product",500));
        }

        return ResponseEntity.status(201).body(new Api("new product is added",201));
    }



    @DeleteMapping("/{index}")
    public ResponseEntity<ArrayList<Product>> delProduct(@PathVariable Integer index){
        return ResponseEntity.status(200).body(productService.delProduct(index));

    }


    @PutMapping("index")
    public ResponseEntity<ArrayList<Product>> updProduct(@PathVariable ArrayList<String> productsNames ,Integer index )
    {
        return ResponseEntity.status(200).body(productService.updProduct(productsNames , index));
    }

}
