package payment_backend.controller;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payment_backend.dto.CreateOrderRequest;
import payment_backend.dto.CreateOrderResponse;
import payment_backend.dto.VerifyPaymentRequest;
import payment_backend.entity.Payment;
import payment_backend.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // ============================================================
    // CREATE ORDER
    // ============================================================
    @PostMapping("/create-order")
    public ResponseEntity<CreateOrderResponse> createOrder(
            @Valid @RequestBody CreateOrderRequest request) {
        CreateOrderResponse response = paymentService.createOrder(request.getAmount());
        return ResponseEntity.ok(response);
    }

    // ============================================================
    // VERIFY PAYMENT
    // ============================================================
    @PostMapping("/verify")
    public ResponseEntity<String> verifyPayment(
            @Valid @RequestBody VerifyPaymentRequest request) {
        String result = paymentService.verifyPayment(request);
        return ResponseEntity.ok(result);
    }

    // ============================================================
    // GET PAYMENT
    // ============================================================
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPayment(id));
    }
}

