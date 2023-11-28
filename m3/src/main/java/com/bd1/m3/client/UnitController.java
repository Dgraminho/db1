package com.bd1.m3.client;

import com.bd1.m3.service.UnitService;
import com.bd1.m3.service.dto.UnitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/unit")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUnit(@RequestBody UnitDTO unitDTO) {
        unitService.createUnit(unitDTO);
        return ResponseEntity.ok().build();
    }
}
