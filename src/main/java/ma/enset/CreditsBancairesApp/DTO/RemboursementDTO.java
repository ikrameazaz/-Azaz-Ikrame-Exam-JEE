package ma.enset.CreditsBancairesApp.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private String type;
    private Long creditId;
}
