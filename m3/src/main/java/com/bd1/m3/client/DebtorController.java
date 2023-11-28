package com.bd1.m3.client;

import com.bd1.m3.service.DebtorService;
import com.bd1.m3.service.dto.DebtorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/debtor")
public class DebtorController {

    private final DebtorService debtorService;

    public DebtorController(DebtorService debtorService) {
        this.debtorService = debtorService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUnit(@RequestBody DebtorDTO debtorDTO) {
        debtorService.createDebtor(debtorDTO);
        return ResponseEntity.ok().build();
    }
}
