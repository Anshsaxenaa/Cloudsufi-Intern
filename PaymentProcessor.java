public class PaymentProcessor {
    public static void processPayment(Payment p) {
        if (p instanceof CardPayment cardPayment) {
            System.out.println("Processing card payment" + cardPayment.getCardNumber());
        } else if (p instanceof UpiPayment upiPayment) {
            System.out.println("Processing upi payment" + upiPayment.getUpiId());
        }
    }
}