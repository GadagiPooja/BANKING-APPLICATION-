package com.example.Banking.Application.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Banking.Application.Dto.AccountDto;
import com.example.Banking.Application.Entity.Account;
import com.example.Banking.Application.Mapper.AccountMapper;
import com.example.Banking.Application.Repository.AccountRepo;
import com.example.Banking.Application.Service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepo accrepo;

	public AccountServiceImpl(AccountRepo accrepo) {
		this.accrepo = accrepo;
	}

	@Override
	public AccountDto createAccount(AccountDto accDto) {
		// TODO Auto-generated method stub
		Account acc = AccountMapper.MapToAccount(accDto);
		Account savedAcc= accrepo.save(acc);
		return AccountMapper.MapToAccountDto(savedAcc);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		
		 Account acc=accrepo.findById(id).orElseThrow(()->new RuntimeException("Error"));
		// TODO Auto-generated method stub
		 return AccountMapper.MapToAccountDto(acc);
		 }

	@Override
	public AccountDto deposite(Long id, Double amt) {
		// TODO Auto-generated method stub
		Account acc=accrepo.findById(id).orElseThrow(()-> new RuntimeException("Error"));
		
		Double total=acc.getBalance()+amt;
		acc.setBalance(total);
		Account savedAcc=accrepo.save(acc);
		return AccountMapper.MapToAccountDto(savedAcc);
		
			}

	@Override
	public AccountDto withdraw( Long id, Double amt) {
		// TODO Auto-generated method stub
		Account acc=accrepo.findById(id).orElseThrow(()-> new RuntimeException("Error"));
		
		if(acc.getBalance() < amt) 
			throw new RuntimeException("Less Amt");
		
	  double total= acc.getBalance()-amt;
	  acc.setBalance(total);
	  
	  Account savedAcc=accrepo.save(acc);
		return AccountMapper.MapToAccountDto(savedAcc);
		
	}

	@Override
	public List<AccountDto> getAllAcc() {
		// TODO Auto-generated method stub
		
		List<Account> acc= accrepo.findAll();
		return acc.stream().map((ac) -> AccountMapper.MapToAccountDto(ac)).collect(Collectors.toList());

		
	}

	@Override
	public void deleteAcc(Long id) {
		// TODO Auto-generated method stub
		Account acc=accrepo.findById(id).orElseThrow(()-> new RuntimeException("Error"));
		
		accrepo.deleteById(id);
	}

}
