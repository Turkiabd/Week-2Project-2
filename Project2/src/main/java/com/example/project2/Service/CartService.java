package com.example.project2.Service;

import com.example.project2.model.Cart;
import com.example.project2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    ArrayList <Cart> carts = new ArrayList<>();
    public ArrayList<Cart> getCart() {
        return carts;
    }






    public Cart getCart1(String cartId){
        for (Cart cart: carts) {
            if(cart.getId().equals(cartId)){
                return cart;
            }


        }
        return null;
    }









}
