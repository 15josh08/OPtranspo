package com.lostandfound.OPtranspo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lostandfound.OPtranspo.DAO.EntitiesDao;
import com.lostandfound.OPtranspo.Support.Entities;
import com.lostandfound.OPtranspo.Support.UserPrincipal;
@SuppressWarnings("unused")
@Service
public class MyUserDetailService implements UserDetailsService {
	private EntitiesDao entitiesDao;
	
	@Autowired
    public MyUserDetailService(EntitiesDao entitiesDao) {
        this.entitiesDao = entitiesDao;
    }
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Entities user = entitiesDao.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new UserPrincipal(user);
	}
	
}
