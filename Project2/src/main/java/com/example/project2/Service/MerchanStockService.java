package com.example.project2.Service;

import com.example.project2.model.Merchant;
import com.example.project2.model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchanStockService {
    ArrayList<MerchantStock> merchantsStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantsStock() {
        return merchantsStocks;
    }

    public Boolean addMerchantStock(MerchantStock merchantStock) {
        return merchantsStocks.add(merchantStock);

    }

    public ArrayList<MerchantStock> delMerchantStock(Integer index) {
        merchantsStocks.remove(index);
        return merchantsStocks;
    }

    public ArrayList<MerchantStock>updMerchantStock (ArrayList<String> merchantsStockNames, Integer index) {
        merchantsStockNames.set(index , "");
        return merchantsStocks;

    }

    public MerchantStock getMerchantsStocks(String merchanStockId) {
        for (MerchantStock merchantStock:merchantsStocks) {
            if(merchantStock.getId().equals(merchanStockId));
            return merchantStock;

        }
        return null;
    }

    public MerchantStock getStock(Integer stock){
        for (MerchantStock merchantStock:merchantsStocks) {
            if(merchantStock.getStock().equals(stock)){
                return merchantStock ;
            }

        }
        return null;
    }

    public MerchantStock getStockPro(String productId){
        for (MerchantStock merchantStock:merchantsStocks) {
            if(merchantStock.getMerchantId().equals(productId)){
                return merchantStock ;
            }

        }
        return null;
    }






}
