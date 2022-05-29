package com.example.project2.Service;

import com.example.project2.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<User> users = new ArrayList<>();
    private final ProductService productService;
    private final CartService cartService;
    private final MerchanStockService merchanStockService;
    private final PurchaseHistoryService purchaseHistoryService;

    public ArrayList<User> getUsers() {
        return users;
    }

    public Boolean addUser(User user ) {
        return users.add(user);

    }

    public ArrayList<User> delUser(Integer index) {
        users.remove(index);
        return users;
    }

    public ArrayList<User>updUser(ArrayList<String> usersNames, Integer index) {
        usersNames.set(index , "");
        return users;

    }

    public Integer addProductToCart(String userId , String productId){
        User user = getUser(userId);
        Product product = productService.getProductsId(productId);
        Cart cart = cartService.getCart1(productId);

        if(user == null || product == null || cart == null){
            return -1;
        }

        cart.getProducts().add(product);
        return 0;

    }


    public Integer removeProductFromCart(String userId , String productId){
        User user = getUser(userId);
        Product product = productService.getProductsId(productId);
        Cart cart = cartService.getCart1(productId);

        if(user == null || product == null || cart == null){
            return -1;
        }

        cart.getProducts().remove(product);
        return 0;

    }


    public Integer addProductToMerchantStock(String productId , String merchantStockId , Integer stock){

        Product product = productService.getProductsId(productId);
        //Product product1 = productService.
        MerchantStock merchantStock = merchanStockService.getMerchantsStocks(merchantStockId);
        MerchantStock merchantStock1 = merchanStockService.getStock(stock);
        MerchantStock merchantStock2 = merchanStockService.getStockPro(productId);

        if(product == null || merchantStock == null){
            return -1;
        }
        merchantStock2.setPrductId(productId);
        merchantStock.setStock(merchantStock.getStock()+1);
        return 0;



    }

    public Integer buyDirect(String userId , String productId , String merchantId){
        User user = getUser(userId);
        Product product = productService.getProductsId(productId);
       MerchantStock merchantStock = merchanStockService.getStockPro(productId);

        if(user == null || product == null || merchantStock == null){
            return -1;
        }

        if(!merchantStock.getMerchantId().contains(productId)){
            return 0;

        }

        if(user.getBalance() < product.getPrice()){
            return 1;
        }

        user.setBalance(user.getBalance()-product.getPrice());

        merchantStock.setStock(merchantStock.getStock()-1);
        return 2;



    }



//
//    public Integer buyFromCart(Cart cart , String userId , String cartId){
//        User user = getUser(userId);
//        Cart cart1 = cartService.getCart1(cartId);
//
//        if(user == null || cart1 == null){
//            return -1;
//        }
//
//        if(user.getBalance()){
//
//        }
//
//
//    }






    public User getUser(String userId){
        for (User user: users) {
            if(user.getId().equals(userId)){
                return user;
            }


        }
        return null;
    }


}
