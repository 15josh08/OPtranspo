package com.lostandfound.OPtranspo.Controllers;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController

public class LoginController {

@PostMapping("/login")   
    public String defaultAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("admin"))) {
            return "redirect:/admin/home";
        } else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("driver"))) {
            return "redirect:/driver/home";
        } else 
        	return "Invalid login";
    }
}
