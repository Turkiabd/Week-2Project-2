package com.example.project2.Controller;


import com.example.project2.Service.PurchaseHistoryService;
import com.example.project2.model.PurchaseHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/purchasehistory")
@RequiredArgsConstructor
public class PurchaseHistoryController {


    private final PurchaseHistoryService purchaseHistoryService ;

    @GetMapping
    public ResponseEntity<ArrayList<PurchaseHistory>> getPurchaseHistory(){
        return ResponseEntity.status(200).body(purchaseHistoryService.getPurchaseHistory());
    }

}
