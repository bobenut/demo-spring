package com.kxh.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kxh.example.demo.domain.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Long> {
	Contact findByName(String name);
	
	List<Contact> findByNameLike(String name);
}
