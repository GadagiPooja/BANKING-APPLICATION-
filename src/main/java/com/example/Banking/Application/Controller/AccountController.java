package com.example.Banking.Application.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking.Application.Dto.AccountDto;
import com.example.Banking.Application.Service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accSer;

	public AccountController(AccountService accSer) {
		this.accSer = accSer;
	}
	
	
	// ADD ACCOUNT REST API
	
	@PostMapping
	public ResponseEntity<AccountDto> addAcc(@RequestBody AccountDto accDto){
		return new ResponseEntity<>(accSer.createAccount(accDto),HttpStatus.CREATED);
	}
	
	// GET ID
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAcc(@PathVariable Long id){
		AccountDto accDto= accSer.getAccountById(id);
		return  ResponseEntity.ok(accDto);
	}
	
	
	
	// PUT AMOUNT
	@PutMapping("{id}/deposite")
	public ResponseEntity<AccountDto> depositeAmt(@PathVariable Long id,@RequestBody Map<String, Double> req){
		Double amt=req.get("amt");
		AccountDto accDto=accSer.deposite(id, amt);
		return  ResponseEntity.ok(accDto);

	}
	
	
	//REMOVE AMOUNT
	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String, Double> req){
		Double amt=req.get("amt");
		AccountDto accDto=accSer.withdraw(id, amt);
		return  ResponseEntity.ok(accDto);

	}
	
	//Get All
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAll(){
		
		List<AccountDto> acc=accSer.getAllAcc();
		return  ResponseEntity.ok(acc);

	} 
	
	//Delete Account
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAcc(@PathVariable Long id){
		
		accSer.deleteAcc(id);
		return  ResponseEntity.ok("Done");

	} 
	
}
