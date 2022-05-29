package com.example.project2.Controller;

import com.example.project2.Service.CategoryService;
import com.example.project2.Service.ProductService;
import com.example.project2.model.Api;
import com.example.project2.model.Category;
import com.example.project2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategory());
    }


    @PostMapping
    public ResponseEntity<Api> addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage() , 400));
        }
        Boolean isCategoryAdded = categoryService.addCategory(category);
        if(!isCategoryAdded  ){

            return ResponseEntity.status(500).body(new Api("error adding a category",500));
        }

        return ResponseEntity.status(201).body(new Api("new category is added",201));
    }



    @DeleteMapping("/{index}")
    public ResponseEntity<ArrayList<Category>> delCategory(@PathVariable Integer index){
        return ResponseEntity.status(200).body(categoryService.delCategory(index));

    }


    @PutMapping("index")
    public ResponseEntity<ArrayList<Category>> updCategory(@PathVariable ArrayList<String> categoryNames ,Integer index )
    {
        return ResponseEntity.status(200).body(categoryService.updCategory(categoryNames , index));
    }

}
