interface PaymentProcessor {
    void processPayment();
}

class PayPal {
    public void makePayment() {
        System.out.println("Payment made using PayPal");
    }
}

class Stripe {
    public void makeStripePayment() {
        System.out.println("Payment made using Stripe");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment() {
        payPal.makePayment();
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment() {
        stripe.makeStripePayment();
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        payPalProcessor.processPayment();

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment();
    }
}
