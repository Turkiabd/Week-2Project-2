package com.example.project2.Service;

import com.example.project2.model.PurchaseHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PurchaseHistoryService {
    ArrayList<PurchaseHistory> purchaseHistories = new ArrayList<>();
    public ArrayList<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistories;
    }
}
