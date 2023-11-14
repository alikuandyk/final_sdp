// Strategy Pattern

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        if (validateCreditCard()) {
            processPayment(amount);
            System.out.println("Payment successful with credit card.");
        } else {
            System.out.println("Credit card validation failed. Payment unsuccessful.");
        }
    }

    private boolean validateCreditCard() {
        // Placeholder for credit card validation logic
        // For simplicity, assume the credit card is always valid in this example
        return true;
    }

    private void processPayment(double amount) {
        // Placeholder for payment processing logic
        // In a real-world scenario, you would connect to a payment gateway
        System.out.println("Processing credit card payment of $" + amount);
    }
}
