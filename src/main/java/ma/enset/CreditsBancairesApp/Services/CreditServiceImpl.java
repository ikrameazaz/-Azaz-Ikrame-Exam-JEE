package ma.enset.CreditsBancairesApp.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.CreditsBancairesApp.DTO.*;
import ma.enset.CreditsBancairesApp.Services.CreditService;
import ma.enset.CreditsBancairesApp.entities.*;
import ma.enset.CreditsBancairesApp.Mappers.CreditBancaireMapper;
import ma.enset.CreditsBancairesApp.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService {

    private ClientRepository clientRepository;
    private CreditRepository creditRepository;
    private RemboursementRepository remboursementRepository;
    private CreditBancaireMapper mapper;

    // ======== CLIENT ========
    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClient(Long id) {
        return clientRepository.findById(id).map(mapper::fromClient).orElse(null);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream().map(mapper::fromClient).collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    // ======== CREDITS ========
    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client == null) return null;

        CreditPersonnel credit = new CreditPersonnel();
        credit.setClient(client);
        credit.setDateDemande(new Date());
        credit.setStatut(StatutCredit.EN_COURS);
        credit.setMontant(dto.getMontant());
        credit.setDureeRemboursement(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setMotif(dto.getMotif());

        return mapper.fromCreditPersonnel((CreditPersonnel) creditRepository.save(credit));
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client == null) return null;

        CreditImmobilier credit = new CreditImmobilier();
        credit.setClient(client);
        credit.setDateDemande(new Date());
        credit.setStatut(StatutCredit.EN_COURS);
        credit.setMontant(dto.getMontant());
        credit.setDureeRemboursement(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setTypeBien(TypeBien.valueOf(dto.getTypeBien()));

        return mapper.fromCreditImmobilier((CreditImmobilier) creditRepository.save(credit));
    }

    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client == null) return null;

        CreditProfessionnel credit = new CreditProfessionnel();
        credit.setClient(client);
        credit.setDateDemande(new Date());
        credit.setStatut(StatutCredit.EN_COURS);
        credit.setMontant(dto.getMontant());
        credit.setDureeRemboursement(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setMotif(dto.getMotif());
        credit.setRaisonSocialeEntreprise(dto.getRaisonSocialeEntreprise());

        return mapper.fromCreditProfessionnel((CreditProfessionnel) creditRepository.save(credit));
    }

    @Override
    public List<CreditDTO> getCreditsByClient(Long clientId) {
        return creditRepository.findAll().stream()
                .filter(c -> c.getClient() != null && c.getClient().getId().equals(clientId))
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditDTO> listAllCredits() {
        return creditRepository.findAll().stream().map(mapper::fromCredit).collect(Collectors.toList());
    }

    // ======== REMBOURSEMENTS ========
    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO dto, Long creditId) {
        Credit credit = creditRepository.findById(creditId).orElse(null);
        if (credit == null) return null;

        Remboursement remboursement = mapper.toRemboursementEntity(dto);
        remboursement.setCredit(credit);

        return mapper.fromRemboursement(remboursementRepository.save(remboursement));
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByCredit(Long creditId) {
        return remboursementRepository.findAll().stream()
                .filter(r -> r.getCredit() != null && r.getCredit().getId().equals(creditId))
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }
}
