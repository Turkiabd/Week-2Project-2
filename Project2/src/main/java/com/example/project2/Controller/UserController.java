package com.example.project2.Controller;

import com.example.project2.Service.ProductService;
import com.example.project2.Service.UserService;
import com.example.project2.model.Api;
import com.example.project2.model.Product;
import com.example.project2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
 private final UserService userService ;


    @GetMapping
    public ResponseEntity<ArrayList<User>> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }


    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage() , 400));
        }
        Boolean isUserAdded = userService.addUser(user);
        if(!isUserAdded ){

            return ResponseEntity.status(500).body(new Api("error adding a user",500));
        }

        return ResponseEntity.status(201).body(new Api("new product is user",201));
    }



    @DeleteMapping("/{index}")
    public ResponseEntity<ArrayList<User>> delUser(@PathVariable Integer index){
        return ResponseEntity.status(200).body(userService.delUser(index));

    }


    @PutMapping("/index")
    public ResponseEntity<ArrayList<User>> updProduct(@PathVariable ArrayList<String> usersNames ,Integer index )
    {
        return ResponseEntity.status(200).body(userService.updUser(usersNames , index));
    }


    @PostMapping("/addtocart")
    public ResponseEntity<Api> addProductToCart(@RequestBody @Valid String userId , String productId , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage() ,400));
        }

        Integer cartUserCase =userService.addProductToCart(userId , productId);
        return switch (cartUserCase) {
            case -1 -> ResponseEntity.status(400).body(new Api("user id or product shpuld not be null", 400));
            case 0 -> ResponseEntity.status(200).body(new Api("product added to the cart", 200));
            default -> ResponseEntity.status(500).body(new Api("server error", 500));
        };
    }




    @DeleteMapping("/remove/fromcart")
    public ResponseEntity<Api> removeProductFromCart( @RequestParam String userId , @RequestParam String productId){


        Integer cartUserCase2 =userService.removeProductFromCart(userId , productId);
        return switch (cartUserCase2) {
            case -1 -> ResponseEntity.status(400).body(new Api("user id or product shpuld not be null", 400));
            case 0 -> ResponseEntity.status(200).body(new Api("product removed from the cart", 200));
            default -> ResponseEntity.status(500).body(new Api("server error", 500));
        };

    }
    @PostMapping("/add/producttomerchantstock")
    public ResponseEntity<Api> addProductToMerchantStock(@RequestParam String productId , @RequestParam String merchantStockId
                                                                                 ,@RequestParam Integer stock){

        Integer merchantCase = userService.addProductToMerchantStock(productId ,merchantStockId , stock);

        return switch (merchantCase) {
            case -1 ->
                    ResponseEntity.status(400).body(new Api("product id or merchan stock id should not be null", 400));
            case 0 -> ResponseEntity.status(200).body(new Api("produc added to merchant stock", 200));
            default -> ResponseEntity.status(500).body(new Api("server error", 500));
        };


    }

    @PostMapping("/buy/direct")
    public ResponseEntity<Api> buyDirect(@RequestParam String userId , @RequestParam String productId ,
                                         @RequestParam String merchantId){

        Integer buyDirCase = userService.buyDirect(userId , productId ,merchantId);
        return switch (buyDirCase) {
            case -1 -> ResponseEntity.status(400).body(new Api("none of the inputs should be null", 400));
            case 0 -> ResponseEntity.status(400).body(new Api("the product  is out of stock", 400));
            case 1 -> ResponseEntity.status(400).body(new Api("Your balance is than product type", 400));
            case 2 -> ResponseEntity.status(200).body(new Api("Successful purchase  ", 200));
            default -> ResponseEntity.status(500).body(new Api("Server Error!!!", 500));
        };


    }









}
