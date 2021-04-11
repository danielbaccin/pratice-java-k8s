package com.kenuiworks.pratice.java.k8s;

import com.kenuiworks.pratice.java.k8s.model.Squad;
import com.kenuiworks.pratice.java.k8s.repository.SquadRepository;
import com.kenuiworks.pratice.java.k8s.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class PraticeJavaK8sApplication {

	@Autowired
	private SquadService service;

	@Autowired
	private SquadRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PraticeJavaK8sApplication.class, args);
	}

	@PostConstruct
	public void setUp(){
		repository.deleteAll();

		service.create(new Squad(null, "Pigs", LocalDate.of(2020, 10, 06), 8));
		service.create(new Squad(null, "Ducks", LocalDate.of(2020, 11, 06), 6));
		service.create(new Squad(null, "Scorpions", LocalDate.of(2020, 12, 06), 3));
	}


}
