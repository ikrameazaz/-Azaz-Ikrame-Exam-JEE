package ma.enset.CreditsBancairesApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CREDIT", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDemande;
    @Enumerated(EnumType.STRING)
    private StatutCredit statut;
    @Temporal(TemporalType.DATE)
    private Date dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement; // en mois
    private Double tauxInteret;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "credit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Remboursement> remboursements;
}
