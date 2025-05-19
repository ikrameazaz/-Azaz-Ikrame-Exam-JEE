package ma.enset.CreditsBancairesApp.Mappers;

import ma.enset.CreditsBancairesApp.DTO.*;
import ma.enset.CreditsBancairesApp.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreditBancaireMapper {
    // === Client ===
    public ClientDTO fromClient(Client client) {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }

    public Client fromClientDTO(ClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    // === Crédit général ===
    public CreditDTO fromCredit(Credit credit) {
        CreditDTO dto = new CreditDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setStatut(credit.getStatut().name());
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        return dto;
    }

    // === Crédit Personnel ===
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setStatut(credit.getStatut().name());
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        return dto;
    }

    // === Crédit Immobilier ===
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setStatut(credit.getStatut().name());
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        dto.setTypeBien(credit.getTypeBien().name());
        return dto;
    }

    // === Crédit Professionnel ===
    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setStatut(credit.getStatut().name());
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
        return dto;
    }

    // === Remboursement ===
    public RemboursementDTO fromRemboursement(Remboursement r) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(r, dto);
        if (r.getCredit() != null) dto.setCreditId(r.getCredit().getId());
        dto.setType(r.getType().name());
        return dto;
    }

    public Remboursement toRemboursementEntity(RemboursementDTO dto) {
        Remboursement r = new Remboursement();
        BeanUtils.copyProperties(dto, r);
        r.setType(TypeRemboursement.valueOf(dto.getType()));
        return r;
    }


}

