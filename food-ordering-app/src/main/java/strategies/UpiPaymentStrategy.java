package strategies;

public class UpiPaymentStrategy implements PaymentStrategy {
    private String mobile;

    public UpiPaymentStrategy(String mobile){
        this.mobile = mobile;
    }

    @Override
    public void pay(double amt){
        System.out.println("Paid " + amt + " to " + mobile + " using UPI.");
    }
}
