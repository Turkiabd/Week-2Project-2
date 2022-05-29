package com.example.project2.Controller;


import com.example.project2.Service.MerchantService;
import com.example.project2.model.Api;
import com.example.project2.model.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/Merchan")
@RequiredArgsConstructor
public class MerchanController {

private final MerchantService merchantService ;


    @GetMapping
    public ResponseEntity<ArrayList<Merchant>>getMerchants(){
        return ResponseEntity.status(200).body(merchantService.getMerchants());
    }


    @PostMapping
    public ResponseEntity<Api> addMerchant (@RequestBody @Valid Merchant merchant , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage() , 400));
        }
        Boolean isMerchantAdded =merchantService.addMerchant(merchant);
        if(!isMerchantAdded ){

            return ResponseEntity.status(500).body(new Api("error adding a merchant",500));
        }

        return ResponseEntity.status(201).body(new Api("new merchant is added",201));
    }



    @DeleteMapping("/{index}")
    public ResponseEntity<ArrayList<Merchant>> delMerchant(@PathVariable Integer index){
        return ResponseEntity.status(200).body(merchantService.delMerchant(index));

    }


    @PutMapping("index")
    public ResponseEntity<ArrayList<Merchant>> updMerchant(@PathVariable ArrayList<String> merchantsNames ,Integer index )
    {
        return ResponseEntity.status(200).body(merchantService.updMerchant(merchantsNames , index));
    }
}
