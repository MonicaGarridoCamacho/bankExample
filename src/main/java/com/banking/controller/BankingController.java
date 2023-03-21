package com.banking.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.jdbc.Transactions;

@RestController

@RequestMapping("test")
public class BankingController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/transactions")
	public @ResponseBody JSONArray transactions() {
		List<String> list = new ArrayList<>();
		JSONArray listJSON = new JSONArray();
		jdbcTemplate.query("SELECT * FROM transactions", new Object[] {},
				(rs, rowNum) -> new Transactions(rs.getString("accountId"), rs.getString("transactionId"),
						rs.getString("transactionInformation"), rs.getString("addressLine"), rs.getString("amount")))
				.forEach(thing -> list.add(thing.toString()));
		 
		System.out.println("list Moni " + list);
	    //This part is not working.
	    try {
	    	
	        for (int i = 0; i < list.size(); i++) {
	        	JSONObject json = new JSONObject();	
	        	System.out.println("list Moni Objeto" + list.get(i));
	        	json.put("key1", list.get(i));
	        	listJSON.put(json);
	        }
	    } catch (Exception e) {
	    }
	    System.out.println("list Moni listJSON " + listJSON);
	    return listJSON;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
	    return "Hello " + name;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/accounts")
    public Transactions transactionsId(@RequestParam(name = "accountId", defaultValue = "0") String accountId) {
        List<String> list = new ArrayList<>();
        list.add("Table data...");
        return jdbcTemplate.queryForObject(
                "SELECT * FROM transactions WHERE accountId=?", new Object[]{ accountId },
                (rs,rowNum) -> new Transactions(rs.getString("accountId"), rs.getString("transactionId"), rs.getString("transactionInformation"), rs.getString("addressLine"), rs.getString("amount")));

    }

}