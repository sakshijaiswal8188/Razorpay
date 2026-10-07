package payment_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payment_backend.entity.Payment;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByRazorpayOrderId(String razorpayOrderId);
}

