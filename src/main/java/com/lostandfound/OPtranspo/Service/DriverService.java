package com.lostandfound.OPtranspo.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostandfound.OPtranspo.DAO.ItemsDao;
import com.lostandfound.OPtranspo.Support.Items;

@Service
public class DriverService {
	@Autowired
	ItemsDao itemsDao;

	public void addItem(String name, LocalDate date, int busNumber, String busRoute, boolean status, int driverId) {
		Items item = new Items();
		item.setName(name);
		item.setDateColumn(date);
		item.setBusNumber(busNumber);
		item.setBusRoute(busRoute);
		item.setStatus(status);
		item.setDriverId(driverId);
		itemsDao.save(item);
	}
	
}
