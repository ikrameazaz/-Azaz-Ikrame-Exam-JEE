
package ma.enset.CreditsBancairesApp.web;

import lombok.AllArgsConstructor;
import ma.enset.CreditsBancairesApp.DTO.*;
import ma.enset.CreditsBancairesApp.Services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
@AllArgsConstructor
@CrossOrigin("*")
public class CreditController {

    private CreditService creditService;

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.listAllCredits();
    }

    @GetMapping("/byClient/{clientId}")
    public List<CreditDTO> getCreditsByClient(@PathVariable Long clientId) {
        return creditService.getCreditsByClient(clientId);
    }

    @PostMapping("/personnel/{clientId}")
    public CreditPersonnelDTO addCreditPersonnel(@RequestBody CreditPersonnelDTO dto, @PathVariable Long clientId) {
        return creditService.saveCreditPersonnel(dto, clientId);
    }

    @PostMapping("/immobilier/{clientId}")
    public CreditImmobilierDTO addCreditImmobilier(@RequestBody CreditImmobilierDTO dto, @PathVariable Long clientId) {
        return creditService.saveCreditImmobilier(dto, clientId);
    }

    @PostMapping("/professionnel/{clientId}")
    public CreditProfessionnelDTO addCreditProfessionnel(@RequestBody CreditProfessionnelDTO dto, @PathVariable Long clientId) {
        return creditService.saveCreditProfessionnel(dto, clientId);
    }
}
