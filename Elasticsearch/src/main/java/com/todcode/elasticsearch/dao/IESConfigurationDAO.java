package com.todcode.elasticsearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todcode.elasticsearch.model.ESConfiguration;


public interface IESConfigurationDAO extends JpaRepository<ESConfiguration, Integer> {

  ESConfiguration findById(int id);
  
  ESConfiguration findESConfigurationById(int id);
//  
//  ESConfiguration getUserByUsername(String username);
//  
//  List<ESConfiguration> findUsersByFirstNameContaining(String firstName);
//  
//  List<ESConfiguration> findUsersByLastNameContaining(String lastName);
//  
//  List<ESConfiguration> getUsersByFirstName(String firstName);
//  
//  List<ESConfiguration> getUsersByLastName(String lastName);
//  
//  List<ESConfiguration> findAll();
  
  
}
