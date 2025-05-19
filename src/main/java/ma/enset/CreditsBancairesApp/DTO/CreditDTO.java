package ma.enset.CreditsBancairesApp.DTO;

import lombok.Data;
@Data
public class CreditDTO {
    private Long id;
    private Double montant;
    private int dureeRemboursement;
    private Double tauxInteret;
    private String statut;
    private Long clientId;
}
