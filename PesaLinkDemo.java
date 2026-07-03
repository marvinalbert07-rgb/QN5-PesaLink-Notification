/**
 * Demonstrates the composition-based Notification module:
 * one notification, several channels, one shared config object.
 */
public class PesaLinkDemo {
    public static void main(String[] args) {
        Notifier notifier = new Notifier();
        notifier.addChannel(new SmsChannel());
        notifier.addChannel(new EmailChannel());
        notifier.addChannel(new WhatsAppChannel());

        notifier.notifyCustomer("+256700000000",
                "UGX 50,000 received on your PesaLink wallet.");

        // Prove GatewayConfig is a true singleton: same instance everywhere
        GatewayConfig c1 = GatewayConfig.getInstance();
        GatewayConfig c2 = GatewayConfig.getInstance();
        System.out.println("\nSame GatewayConfig instance? " + (c1 == c2));
        System.out.println("Retry limit from shared config: " + c1.getRetryLimit());
    }
}
