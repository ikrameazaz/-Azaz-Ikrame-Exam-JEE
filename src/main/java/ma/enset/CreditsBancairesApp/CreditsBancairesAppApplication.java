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

	@Bean
	CommandLineRunner start(
			ClientRepository clientRepository,
			CreditRepository creditRepository,
			RemboursementRepository remboursementRepository) {
		return args -> {
			System.out.println("=== Création des clients ===");
			Stream.of("ikrame", "AZAZ", "ZAk").forEach(name -> {
				Client client = new Client();
				client.setNom(name);
				client.setEmail(name.toLowerCase() + "@gmail.com");
				clientRepository.save(client);
			});

			System.out.println("=== Création des crédits ===");

			Client client1 = clientRepository.findById(1L).orElse(null);
			Client client2 = clientRepository.findById(2L).orElse(null);
			Client client3 = clientRepository.findById(3L).orElse(null);

			CreditPersonnel creditPersonnel = new CreditPersonnel();
			creditPersonnel.setClient(client1);
			creditPersonnel.setDateDemande(new Date());
			creditPersonnel.setStatut(StatutCredit.EN_COURS);
			creditPersonnel.setMontant(50000.0);
			creditPersonnel.setDureeRemboursement(24);
			creditPersonnel.setTauxInteret(4.5);
			creditPersonnel.setMotif("Achat de voiture");
			creditRepository.save(creditPersonnel);

			CreditImmobilier creditImmobilier = new CreditImmobilier();
			creditImmobilier.setClient(client2);
			creditImmobilier.setDateDemande(new Date());
			creditImmobilier.setStatut(StatutCredit.ACCEPTE);
			creditImmobilier.setDateAcceptation(new Date());
			creditImmobilier.setMontant(200000.0);
			creditImmobilier.setDureeRemboursement(240);
			creditImmobilier.setTauxInteret(2.75);
			creditImmobilier.setTypeBien(TypeBien.APPARTEMENT);
			creditRepository.save(creditImmobilier);

			CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
			creditProfessionnel.setClient(client3);
			creditProfessionnel.setDateDemande(new Date());
			creditProfessionnel.setStatut(StatutCredit.EN_COURS);
			creditProfessionnel.setMontant(100000.0);
			creditProfessionnel.setDureeRemboursement(60);
			creditProfessionnel.setTauxInteret(3.5);
			creditProfessionnel.setMotif("Expansion d'entreprise");
			creditProfessionnel.setRaisonSocialeEntreprise("SARL Example");
			creditRepository.save(creditProfessionnel);

			System.out.println("=== Création des remboursements ===");

			Remboursement remboursement1 = new Remboursement();
			remboursement1.setCredit(creditPersonnel);
			remboursement1.setDate(new Date());
			remboursement1.setMontant(2200.0);
			remboursement1.setType(TypeRemboursement.MENSUALITE);
			remboursementRepository.save(remboursement1);

			Remboursement remboursement2 = new Remboursement();
			remboursement2.setCredit(creditImmobilier);
			remboursement2.setDate(new Date());
			remboursement2.setMontant(950.0);
			remboursement2.setType(TypeRemboursement.MENSUALITE);
			remboursementRepository.save(remboursement2);

			Remboursement remboursement3 = new Remboursement();
			remboursement3.setCredit(creditProfessionnel);
			remboursement3.setDate(new Date());
			remboursement3.setMontant(10000.0);
			remboursement3.setType(TypeRemboursement.REMBOURSEMENT_ANTICIPE);
			remboursementRepository.save(remboursement3);

			System.out.println("=== Résumé des enregistrements ===");
			System.out.println("Clients : " + clientRepository.count());
			System.out.println("Crédits (tous types) : " + creditRepository.count());
			System.out.println("Remboursements : " + remboursementRepository.count());
		};
	}


}
