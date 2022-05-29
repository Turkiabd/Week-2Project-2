package com.example.project2.Controller;


import com.example.project2.Service.MerchanStockService;
import com.example.project2.model.Api;
import com.example.project2.model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/Merchanstock")
@RequiredArgsConstructor
public class MerchanStockController {

    private final MerchanStockService merchanStockService ;


    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantsStock(){
        return ResponseEntity.status(200).body(merchanStockService.getMerchantsStock());
    }


    @PostMapping
    public ResponseEntity<Api> addMerchant (@RequestBody @Valid MerchantStock merchantStock , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage() , 400));
        }
        Boolean isMerchantAdded =merchanStockService.addMerchantStock(merchantStock);
        if(!isMerchantAdded ){

            return ResponseEntity.status(500).body(new Api("error adding a merchant stock",500));
        }

        return ResponseEntity.status(201).body(new Api("new merchant stock is added",201));
    }



    @DeleteMapping("/{index}")
    public ResponseEntity<ArrayList<MerchantStock>> delMerchant(@PathVariable Integer index){
        return ResponseEntity.status(200).body(merchanStockService.delMerchantStock(index));

    }


    @PutMapping("index")
    public ResponseEntity<ArrayList<MerchantStock>> updMerchant(@PathVariable ArrayList<String> merchantsStockNames ,Integer index )
    {
        return ResponseEntity.status(200).body(merchanStockService.updMerchantStock(merchantsStockNames , index));
    }












}
