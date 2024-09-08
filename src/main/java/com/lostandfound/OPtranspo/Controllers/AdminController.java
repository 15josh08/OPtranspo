package com.lostandfound.OPtranspo.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lostandfound.OPtranspo.Service.AdminService;
import com.lostandfound.OPtranspo.Service.EmailService;
import com.lostandfound.OPtranspo.Support.Entities;
import com.lostandfound.OPtranspo.Support.Items;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	EmailService emailService;

	@GetMapping("/home")
	public String adminHome() {
		return "Welcome Admin!";
	}

	@GetMapping("/allusers")
	public List<Entities> getAllData() {
		return adminService.getAllData();
	}

	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestParam String email, @RequestParam String password,
			@RequestParam String userRole) {

		String encodedPassword = new BCryptPasswordEncoder().encode(password);
		adminService.addUser(email, encodedPassword, userRole);

		return ResponseEntity.ok("User added successfully");
	}
	
	@PutMapping("/edititem/{itemId}")
	public ResponseEntity<String> editItem(@PathVariable Integer itemId,@RequestBody Items updaetdItem){
		adminService.editItem(itemId, updaetdItem);
		return ResponseEntity.ok("Editing successfull");
	}
	
	@DeleteMapping("removeitem/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable Integer itemId){
		return adminService.deleteItem(itemId);
		
	}
	@GetMapping("/sendemail")
	public ResponseEntity<String> sendEmail(@RequestParam String recipient){
		return emailService.sendEmail(recipient);
	}

}
