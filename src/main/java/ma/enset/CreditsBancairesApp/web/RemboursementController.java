
package ma.enset.CreditsBancairesApp.web;

import lombok.AllArgsConstructor;
import ma.enset.CreditsBancairesApp.DTO.RemboursementDTO;
import ma.enset.CreditsBancairesApp.Services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
@AllArgsConstructor
@CrossOrigin("*")
public class RemboursementController {

    private CreditService creditService;

    @PostMapping("/{creditId}")
    public RemboursementDTO addRemboursement(@RequestBody RemboursementDTO dto, @PathVariable Long creditId) {
        return creditService.saveRemboursement(dto, creditId);
    }

    @GetMapping("/byCredit/{creditId}")
    public List<RemboursementDTO> getRemboursements(@PathVariable Long creditId) {
        return creditService.getRemboursementsByCredit(creditId);
    }
}

