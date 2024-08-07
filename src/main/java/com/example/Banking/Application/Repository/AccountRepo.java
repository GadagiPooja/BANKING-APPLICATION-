package com.example.Banking.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking.Application.Entity.Account;


//to perform CRUD ope
public interface AccountRepo extends JpaRepository<Account, Long>{

}
