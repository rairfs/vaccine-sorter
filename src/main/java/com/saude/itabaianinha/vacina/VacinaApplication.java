package com.saude.itabaianinha.vacina;

import com.saude.itabaianinha.vacina.services.VacinaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class VacinaApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(VacinaApplication.class, args);
		VacinaService service = new VacinaService("SESP");
		service.combineAndShow();
	}

}
