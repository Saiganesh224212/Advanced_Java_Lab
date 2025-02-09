//Payment Processing System (Applying All SOLID Principles)
//This payment processing system supports multiple payment methods (Credit Card, PayPal, Google Pay) while ensuring maintainability, scalability, and flexibility by applying SOLID principles.
public class diffass3 {

    // Open for extension, closed for modification (OCP)
    // No class is forced to implement unnecessary methods (ISP)
    interface PaymentService {
        boolean authorizePayment(double amount);
        void completePayment(double amount);
    }

    // Each subclass correctly replaces its parent without changing behavior (LSP)
    static class CreditCardPayment implements PaymentService {
        @Override
        public boolean authorizePayment(double amount) {
            System.out.println("Authorizing Credit Card payment of ₹" + amount + "...");
            return true; // Assume authorization is successful
        }

        @Override
        public void completePayment(double amount) {
            System.out.println("Credit Card payment of ₹" + amount + " processed successfully.");
        }
    }

    static class PayPalPayment implements PaymentService {
        @Override
        public boolean authorizePayment(double amount) {
            System.out.println("Validating PayPal account for ₹" + amount + "...");
            return true;
        }

        @Override
        public void completePayment(double amount) {
            System.out.println("PayPal transaction completed successfully for ₹" + amount + ".");
        }
    }

    static class GooglePayPayment implements PaymentService {
        @Override
        public boolean authorizePayment(double amount) {
            System.out.println("Checking Google Pay UPI details for ₹" + amount + "...");
            return true;
        }

        @Override
        public void completePayment(double amount) {
            System.out.println("Google Pay UPI payment of ₹" + amount + " is successful.");
        }
    }

    // High-level module depends on abstraction (DIP)
    // Handles only payment execution (SRP)
    static class PaymentProcessor {
        private PaymentService paymentService;

        public PaymentProcessor(PaymentService paymentService) {
            this.paymentService = paymentService;
        }

        public void executePayment(double amount) {
            if (paymentService.authorizePayment(amount)) {
                paymentService.completePayment(amount);
                System.out.println("Payment processed successfully.");
            } else {
                System.out.println("Payment authorization failed. Transaction cancelled.");
            }
        }
    }

    // Logging responsibility is separated from payment processing (SRP)
    static class PaymentLogger {
        public void logTransaction(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    // ✅ NEW: Service Manager to handle all payment operations to reduce load on Main
    static class PaymentServiceManager {
        private PaymentLogger logger;

        public PaymentServiceManager() {
            this.logger = new PaymentLogger();
        }

        public void processPayment(PaymentService paymentService, double amount, String paymentType) {
            PaymentProcessor processor = new PaymentProcessor(paymentService);
            processor.executePayment(amount);
            logger.logTransaction(paymentType + " payment of ₹" + amount + " completed.");
        }
    }

    public static void main(String[] args) {
        // ✅ Using PaymentServiceManager to handle operations
        PaymentServiceManager manager = new PaymentServiceManager();

        // Processing payments with different methods
        manager.processPayment(new CreditCardPayment(), 100.0, "Credit Card");
        manager.processPayment(new PayPalPayment(), 200.0, "PayPal");
        manager.processPayment(new GooglePayPayment(), 150.0, "Google Pay");
    }
}