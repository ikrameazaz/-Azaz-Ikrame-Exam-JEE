package ma.enset.CreditsBancairesApp.web;

import lombok.AllArgsConstructor;
import ma.enset.CreditsBancairesApp.DTO.ClientDTO;
import ma.enset.CreditsBancairesApp.Services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientRestController {

    private CreditService creditService;

    @GetMapping
    public List<ClientDTO> getClients() {
        return creditService.listClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return creditService.getClient(id);
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO dto) {
        return creditService.saveClient(dto);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO dto) {
        dto.setId(id);
        return creditService.updateClient(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        creditService.deleteClient(id);
    }
}

