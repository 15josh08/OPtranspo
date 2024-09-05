package com.lostandfound.OPtranspo.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lostandfound.OPtranspo.Support.Items;

@Repository
public interface ItemsDao extends JpaRepository<Items, Integer>  {
	public Items findByName(String name);
	public List<Items> findAllByName(String name);
	
}
