package com.openbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openbank.jdbc.Transactions;

@RestController
public class OpenbankController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("test")
    public @ResponseBody ResponseEntity<String> transactions() {
        List<String> list = new ArrayList<>();
        list.add("Table data...");
        jdbcTemplate.query(
                "SELECT * FROM transactions", new Object[]{},
                (rs,rowNum) -> new Transactions(rs.getString("accountId"), rs.getString("transactionId"), rs.getString("transactionInformation"), rs.getString("addressLine"), rs.getString("amount")))
                .forEach(thing -> list.add(thing.toString()));
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }
}