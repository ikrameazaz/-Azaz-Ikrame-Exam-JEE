package ma.enset.CreditsBancairesApp.Services;

import ma.enset.CreditsBancairesApp.DTO.*;

import java.util.List;

public interface CreditService {

    // Clients
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id);
    List<ClientDTO> listClients();
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long id);

    // Crédits
    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto, Long clientId);
    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto, Long clientId);
    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto, Long clientId);

    List<CreditDTO> getCreditsByClient(Long clientId);
    List<CreditDTO> listAllCredits();

    // Remboursements
    RemboursementDTO saveRemboursement(RemboursementDTO dto, Long creditId);
    List<RemboursementDTO> getRemboursementsByCredit(Long creditId);
}
