package com.example.demo;

import com.github.javafaker.Address;
import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloApi {

	@GetMapping
	public Map<String, String> doIt(){
		Faker faker = new Faker();
		Company company = faker.company();
		Address address = faker.address();

		Map<String, String> res = new HashMap<>();

		res.put("name", company.name());
		res.put("logo", company.logo());
		res.put("url", company.url());
		res.put("building_no", address.buildingNumber());
		res.put("city", address.city());
		res.put("address", address.fullAddress());

		return res;
	}

}
