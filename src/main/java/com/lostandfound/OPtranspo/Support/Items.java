package com.lostandfound.OPtranspo.Support;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name = "Items")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;

	private String name;

	private LocalDate date;

	private Integer busNumber;

	private String busRoute;

	private boolean status;

	private Integer driverId;
	
	public Items() {
		
	}

	public Items(Integer itemID, String name, LocalDate date, Integer busNumber, String busRoute, boolean status,
			Integer driverId) {
		super();
		this.itemId = itemID;
		this.name = name;
		this.date = date;
		this.busNumber = busNumber;
		this.busRoute = busRoute;
		this.status = status;
		this.driverId = driverId;
	}

	public int getItemID() {
		return itemId;
	}

	public void setItemID(Integer itemID) {
		this.itemId = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateColumn() {
		return date;
	}

	public void setDateColumn(LocalDate date) {
		this.date = date;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(Integer busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(String busRoute) {
		this.busRoute = busRoute;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
}
