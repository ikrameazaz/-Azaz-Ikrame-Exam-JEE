package ma.enset.CreditsBancairesApp.repositories;

import ma.enset.CreditsBancairesApp.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}