package ma.enset.CreditsBancairesApp.repositories;

import ma.enset.CreditsBancairesApp.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

}