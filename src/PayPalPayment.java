// Strategy Pattern

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        if (authenticateWithPayPal()) {
            double convertedAmount = convertCurrency(amount);
            initiatePayment(convertedAmount);
            System.out.println("Payment successful with PayPal.");
        } else {
            System.out.println("PayPal authentication failed. Payment unsuccessful.");
        }
    }

    private boolean authenticateWithPayPal() {
        // Placeholder for PayPal authentication logic
        // For simplicity, assume the authentication is always successful in this example
        return true;
    }

    private double convertCurrency(double amount) {
        // Placeholder for currency conversion logic if needed
        // For simplicity, assume no currency conversion in this example
        return amount;
    }

    private void initiatePayment(double amount) {
        // Placeholder for PayPal payment initiation logic
        // In a real-world scenario, you would use the PayPal API or SDK
        System.out.println("Initiating PayPal payment of $" + amount);
    }
}
