package ma.enset.CreditsBancairesApp;

import ma.enset.CreditsBancairesApp.entities.*;
import ma.enset.CreditsBancairesApp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class CreditsBancairesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditsBancairesAppApplication.class, args);
	}
}
