package com.lostandfound.OPtranspo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lostandfound.OPtranspo.DAO.ItemsDao;
import com.lostandfound.OPtranspo.Support.Items;

@SuppressWarnings("unused")
@Service
public class UserService {
	@Autowired
	ItemsDao itemsDao; 
	
	public List<Items> searchItem(String itemName) {
		List<Items> itemsList = itemsDao.findAllByName(itemName);
		return itemsList;
		
	}

	public String claimItem(Integer itemId) {
		
			Optional<Items> itemOptional = itemsDao.findById(itemId);
			if(itemOptional.isPresent()) {
				boolean status = true;
				Items item = itemOptional.get();
				item.setStatus(status);
				itemsDao.save(item);
				return "Status changed";
			
		}
			return "Status Unchanged";
		
				
		
	}
}
