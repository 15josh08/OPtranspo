package com.lostandfound.OPtranspo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lostandfound.OPtranspo.Service.UserService;
import com.lostandfound.OPtranspo.Support.Items;
@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
    @GetMapping("/home")
    public String userHome() {
        return "Welcome to the User Home Page!";
    }
    
    @PostMapping("/searchitem")
    public List<Items> searchItem(@RequestParam String itemName) {
    	return userService.searchItem(itemName);
    }
    
    @PostMapping("/claim")
    public String claimItem(@RequestParam Integer itemId){
    	return userService.claimItem(itemId);
    }
}
