package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Phonebook;
import com.example.demo.Repository.PhoneRepository;

@Service("pserv")
public class PhoneService {
	@Autowired
	PhoneRepository prepo;
	public boolean savecontact(Phonebook pc)
	{
		Phonebook p=prepo.save(pc);
		if (p!=null) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	public List<Phonebook> get()
	{
		return prepo.findAll();
	}
	
	public boolean delId(Integer id)
	{
		Optional<Phonebook> o=prepo.findById(id);
		if(o.isPresent())
		{
			prepo.deleteById(id);
			return true;
		}
		else 
		{
			return false;
		}
	}
	public Phonebook getdata(Integer id)
	{
		return prepo.getdata(id);
	}
	public int updatedata(Phonebook p)
	{
		System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getContact());
		return prepo.updatedata(p.getId(),p.getName(), p.getContact());
	}

}
