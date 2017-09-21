package com.kxh.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.kxh.example.demo.domain.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Long> {
	Contact findByName(String name);
	
	List<Contact> findByNameLike(String name);
}
