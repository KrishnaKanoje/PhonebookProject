package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Phonebook;

import jakarta.transaction.Transactional;

public interface PhoneRepository extends JpaRepository<Phonebook,Integer>
{
	@Query("select p from Phonebook p where p.id=:pid")
	public Phonebook getdata(@Param("pid") Integer id );
	
	@Transactional
	@Modifying
	@Query("update Phonebook p set p.name=:name,p.Contact=:contact where p.id=:pid")
	public int updatedata(@Param("pid") Integer id,@Param("name") String name,@Param("contact") String Contact);
}
