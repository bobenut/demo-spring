package com.kxh.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kxh.example.demo.domain.Contact;

@Component
public class ContactsService {
	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Contact> findAllViaProc(String name) {
	   StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("getContactsLikeName");
	   storedProcedureQuery.setParameter("name", name);
	   storedProcedureQuery.execute();
	   return storedProcedureQuery.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> findAllByViaQuery(String name) {
		List<Contact> contacts = this.entityManager
	    		.createNativeQuery("select name, phone, mail from contact where name like :name", "conatctMapping")
	    		.setParameter("name", name)
	    		.setMaxResults(5)
	    		.getResultList();
		
		return contacts;
	}
}
