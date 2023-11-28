package com.bd1.m3.client;

import com.bd1.m3.service.PaymentService;
import com.bd1.m3.service.dto.PaymentDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/create", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Void> createPayment(@Validated @ModelAttribute PaymentDTO paymentDTO) {
        paymentService.createPayment(paymentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Object> download(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.download(id));
    }

    @GetMapping("/find")
    public ResponseEntity<Object> find(){
        return ResponseEntity.ok(paymentService.getPayments());
    }
}
