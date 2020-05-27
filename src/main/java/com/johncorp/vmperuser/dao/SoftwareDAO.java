package com.johncorp.vmperuser.dao;

import org.springframework.data.repository.CrudRepository;

import com.johncorp.vmperuser.model.Software;

public interface SoftwareDAO extends CrudRepository<Software, Integer> {

	
	
}
