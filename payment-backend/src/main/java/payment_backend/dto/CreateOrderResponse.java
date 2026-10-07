package payment_backend.dto;

public class CreateOrderResponse {

    private String keyId;
    private String orderId;
    private Long amount;
    private String currency;

    public CreateOrderResponse() {
    }

    public CreateOrderResponse(String keyId, String orderId, Long amount, String currency) {
        this.keyId = keyId;
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
    }

    public String getKeyId() {
        return keyId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}

