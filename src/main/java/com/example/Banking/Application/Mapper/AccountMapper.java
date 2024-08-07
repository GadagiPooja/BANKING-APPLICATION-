package com.example.Banking.Application.Mapper;

import com.example.Banking.Application.Dto.AccountDto;
import com.example.Banking.Application.Entity.Account;

public class AccountMapper {
	
	
	public static Account MapToAccount(AccountDto accDto) {
		Account  acc= new Account(
				accDto.getId(),
				accDto.getAccountHolderName(),
				accDto.getBalance()
				);
		return acc;
		
	}

	public static AccountDto MapToAccountDto(Account acc) {
		AccountDto  accDto= new AccountDto(
				acc.getId(),
				acc.getAccountHolderName(),
				acc.getBalance()
				);
		return accDto;
		
	}}
