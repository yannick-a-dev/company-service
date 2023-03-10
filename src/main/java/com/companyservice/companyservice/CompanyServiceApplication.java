package com.companyservice.companyservice;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.companyservice.companyservice.dao.CompanyRepository;
import com.companyservice.companyservice.entities.Company;

@EnableDiscoveryClient
@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CompanyRepository companyRepository) {
		return args->{
			Stream.of("A","B","C").forEach(cn->{
				companyRepository.save(new Company(null,cn,100+Math.random()*9000));
			});
			companyRepository.findAll().forEach(System.out::println);
		};
	}

}
