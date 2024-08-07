package com.example.Banking.Application.Service;

import java.util.List;

import com.example.Banking.Application.Dto.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accDto);
	
	AccountDto getAccountById(Long id);
	AccountDto deposite(Long id, Double amt);
	AccountDto withdraw(Long id, Double amt);
	
	List<AccountDto> getAllAcc();
	
	void deleteAcc(Long id);
	

}

