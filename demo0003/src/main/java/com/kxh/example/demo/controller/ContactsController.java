package com.kxh.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kxh.example.demo.dao.ContactsRepository;
import com.kxh.example.demo.domain.Contact;
import com.kxh.example.demo.service.ContactsService;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
	
	@Autowired
	ContactsRepository contactsRepository;
	
	@Autowired
	ContactsService contactsService;
	
	//新增
	@RequestMapping(value="/save/new", method=RequestMethod.POST)
	public Contact saveNewContact(@RequestBody Contact contact) {
		System.out.println(contact.getName() + " " + contact.getPhone() + " " + contact.getMail());
		return this.contactsRepository.save(contact);
	}
	
	//更新
	@RequestMapping(value="/save/updated", method=RequestMethod.PUT)
	public Contact saveUpdatedContact(@RequestBody Contact contact) {
		Contact contactExisted = this.contactsRepository.findByName(contact.getName());
		contactExisted.setPhone(contact.getPhone());
		contactExisted.setMail(contact.getMail());
		return this.contactsRepository.save(contactExisted);
	}
	
	//删除
	@RequestMapping(value="/remove", method=RequestMethod.DELETE)
	public void removeContact(long id) {
		this.contactsRepository.delete(id);
	}
	
	//查询，通过name查询一条
	@RequestMapping(value="/query/byname", method=RequestMethod.GET)
	public Contact findContactByName(String name) {
		Contact contact = this.contactsRepository.findByName(name);
		return contact;
	}
	
	//查询，通过like name查询多条
	@RequestMapping(value="/query/likename", method=RequestMethod.GET)
	public List<Contact> findContactLikeName(String name) {
		String nameWhere = org.apache.commons.lang.StringUtils.join(new String[]{"%", name, "%"}, "");
		List<Contact> contacts = this.contactsRepository.findByNameLike(nameWhere);
		return contacts;
	}
	
	//通过存储过程查
	@RequestMapping(value="/query/viaproc/likename", method=RequestMethod.GET)
	public List<Contact> findContactsUseProcLikeName(String name) {
		System.out.println("kxh1");
		String nameWhere = org.apache.commons.lang.StringUtils.join(new String[]{"%", name, "%"}, "");
		List<Contact> contacts = contactsService.findAllViaProc(nameWhere);
		if(contacts == null) {
			return new ArrayList<Contact>();
		} else {
			return contacts;
		}
	}
	
	//通过动态sql查
	@RequestMapping(value="/query/viadnq/likename", method=RequestMethod.GET)
	public List<Contact> findContactsUseDyanamicQueryLikeName(String name) {
		System.out.println("kxh1");
		String nameWhere = org.apache.commons.lang.StringUtils.join(new String[]{"%", name, "%"}, "");
		List<Contact> contacts = contactsService.findAllByViaQuery(nameWhere);
		if(contacts == null) {
			System.out.println("kxh4");
			return new ArrayList<Contact>();
		} else {
			System.out.println("kxh5");
			return contacts;
		}
	}
}
