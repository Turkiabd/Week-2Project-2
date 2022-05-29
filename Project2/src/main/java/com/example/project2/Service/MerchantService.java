package com.example.project2.Service;

import com.example.project2.model.Merchant;
import com.example.project2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();
    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public Boolean addMerchant(Merchant merchant) {
        return merchants.add(merchant);

    }

    public ArrayList<Merchant> delMerchant(Integer index) {
        merchants.remove(index);
        return merchants;
    }

    public ArrayList<Merchant>updMerchant(ArrayList<String> merchantsNames, Integer index) {
        merchantsNames.set(index , "");
        return merchants;

    }

    public Merchant getMerchantId(String merchantId){
        for (Merchant merchant: merchants) {
            if(merchant.getId().equals(merchantId)){
                return merchant;
            }

        }
        return null ;
    }









}
