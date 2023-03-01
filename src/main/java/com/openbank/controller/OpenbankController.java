package com.openbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class OpenbankController {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @GetMapping("/transactions")
//    public @ResponseBody ResponseEntity<String> transactions() {
//        List<String> list = new ArrayList<>();
//        list.add("Table data...");
//        jdbcTemplate.query(
//                "SELECT * FROM transactions", new Object[]{},
//                (rs,rowNum) -> new Transactions(rs.getString("accountId"), rs.getString("transactionId"), rs.getString("transactionInformation"), rs.getString("addressLine"), rs.getString("amount")))
//                .forEach(thing -> list.add(thing.toString()));
//        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
//    }
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}