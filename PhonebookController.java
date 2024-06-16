package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Phonebook;
import com.example.demo.Service.PhoneService;

@Controller
public class PhonebookController {
	@Autowired
	PhoneService pserv;
	
	@GetMapping(value="/")
	public String homepage1()
	{
		return "NewFile";
	}
	
	@GetMapping(value="/k")
	public String homepage()
	{
		return "Master";
	}
	
	@GetMapping(value="/AddContact")
	public String Contact()
	{
		return "addcontact";
	}
	@PostMapping(value="/save")
	public String savecontact(Phonebook p,Model m)
	{
		boolean b=pserv.savecontact(p);
		if (b) {
			
		m.addAttribute("msg","Saved.....");
		return "Master";
		}
		else {
			m.addAttribute("msg", "Not saved....");
			return "Master";
		}
	}
	
	@GetMapping(value="/getdata")
	public String get(Model m)
	{
		List<Phonebook> pb=pserv.get();
		if (pb!=null) {
			m.addAttribute("data", pb);
			return "viewcontact";
		}
		else {
			m.addAttribute("data",null);
			return "viewcontact";
		}
	}
	
	@GetMapping(value="/del")
	public String delete(@RequestParam("id") Integer id,Model m)
	{
		System.out.println(id);
		boolean b=pserv.delId(id);
		if(b) 
		{
			
		List<Phonebook> pb=pserv.get();
			m.addAttribute("data", pb);
			return "viewcontact";
		}
		else {
			m.addAttribute("data", null);
			return "viewcontact";
		}
	}
	@GetMapping(value="/Update")
	public String upd(@RequestParam("id") Integer id,Model m)
	{
		Phonebook p=pserv.getdata(id);
		m.addAttribute("data", p);
		System.out.println(id);
		return "update";
	}
	
	@PostMapping(value="/upd")
	public String updatedata(Phonebook p,Model m)
	{
		if(pserv.updatedata(p)>0) 
		{
			List<Phonebook> pb=pserv.get();
			m.addAttribute("data", pb);
			return "viewcontact";
		}
		else {
			m.addAttribute("data", null);
			return "viewcontact";
		}
	}
	@GetMapping(value="/vname")
	public String search(@RequestParam("name") String name,Model m)
	{
		System.out.println(name);
		if (name.equals("krishna")){
			m.addAttribute("msg", "already exist");
			return "addcontact";
		}
		else
		{
			m.addAttribute("msg","valid");
			return "addcontact";
		}
		
	
	}
	{
		
	}
	
}
