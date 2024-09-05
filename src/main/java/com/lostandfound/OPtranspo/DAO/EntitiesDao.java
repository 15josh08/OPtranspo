package com.lostandfound.OPtranspo.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.lostandfound.OPtranspo.Support.Entities;
@SuppressWarnings("unused")
@Repository
public interface EntitiesDao extends JpaRepository<Entities, Integer> {

	public Entities findByEmail(String Email);
		
		
		
	
}
