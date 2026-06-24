package strategies;

public class NetBankingPaymentStrategy implements PaymentStrategy {
    private String mobile;

    public NetBankingPaymentStrategy(String mobile){
        this.mobile = mobile;
    }

    @Override
    public void pay(double amt){
        System.out.println("Paid " + amt + " to " + mobile + " using Net Banking.");
    }
}

