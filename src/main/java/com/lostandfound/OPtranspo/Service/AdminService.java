package com.lostandfound.OPtranspo.Service;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lostandfound.OPtranspo.DAO.EntitiesDao;
import com.lostandfound.OPtranspo.DAO.ItemsDao;
import com.lostandfound.OPtranspo.Support.Entities;
import com.lostandfound.OPtranspo.Support.Items;
@SuppressWarnings({"unused","unchecked"})
@Service
public class AdminService {
	
	@Autowired
	EntitiesDao entitiesDao;
	@Autowired
	ItemsDao itemsDao;
	

	public List<Entities> getAllData() {
		return entitiesDao.findAll();
	}

	public void addUser(String email, String password, String userRole) {
		Entities user = new Entities();
		user.setEmail(email);
		user.setPassword(password);
		user.setUserRole(userRole);
		entitiesDao.save(user);
	}

	public void editItem(Integer itemId, Items updatedItem) {
		Optional<Items> optionalItem = itemsDao.findById(itemId);
		if(optionalItem.isPresent()) {
			Items item = optionalItem.get();
			if(updatedItem.getName() != null) {
				item.setName(updatedItem.getName());
			}
			if(updatedItem.getDateColumn() != null) {
				item.setDateColumn(updatedItem.getDateColumn());
			}
			if(updatedItem.getBusNumber().toString() != null) {
				item.setBusNumber(updatedItem.getBusNumber());
			}
			if(updatedItem.getBusRoute() != null) {
				item.setName(updatedItem.getBusRoute());
			}
			if(updatedItem.isStatus()) {
				item.setStatus(updatedItem.isStatus());
			}else if(!updatedItem.isStatus()){
				item.setStatus(false);
			}
			if(updatedItem.getDriverId().toString() != null) {
				item.setDriverId(updatedItem.getDriverId());
			}

			itemsDao.save(item);


		}
	}

	
	public ResponseEntity<String> deleteItem(Integer itemId) {
		Optional<Items> optionalItem = itemsDao.findById(itemId);
		if(optionalItem.isPresent()) {
			Items item = optionalItem.get();
			if(item.isStatus() == true) {
				itemsDao.delete(item);
				return ResponseEntity.ok("Item removed");
			}if(item.isStatus() == false) {
				return (ResponseEntity<String>) ResponseEntity.badRequest();
			}
			return (ResponseEntity<String>) ResponseEntity.notFound();
		}
		return (ResponseEntity<String>) ResponseEntity.accepted();
	}
	
	
}
