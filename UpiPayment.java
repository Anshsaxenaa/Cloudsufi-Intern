public final class UpiPayment implements Payment {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }

}