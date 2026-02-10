
public class Seventh {
    public static void main(String[] args) {
        Payment card = new CardPayment("1234567890");
        Payment upi = new UpiPayment("1234567890");
        PaymentProcessor.processPayment(card);
        PaymentProcessor.processPayment(upi);
    }
}