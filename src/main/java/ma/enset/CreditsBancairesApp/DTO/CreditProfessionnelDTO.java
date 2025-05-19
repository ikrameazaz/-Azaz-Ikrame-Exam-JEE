package ma.enset.CreditsBancairesApp.DTO;

import lombok.Data;

@Data
public class CreditProfessionnelDTO extends CreditDTO{
    private String motif;
    private String raisonSocialeEntreprise;
}

