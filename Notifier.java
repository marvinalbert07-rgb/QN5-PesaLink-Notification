import java.util.ArrayList;
import java.util.List;

/**
 * Notifier is COMPOSED of any number of NotificationChannel objects
 * (composition), and it treats every channel identically through the
 * NotificationChannel interface (polymorphism).
 *
 * This directly satisfies management's new requirements:
 *  1. A single notification can go out over several channels at once
 *     - just add several channels to the same Notifier.
 *  2. Channels can be swapped or extended at runtime by adding/removing
 *     NotificationChannel objects - no recompilation of Notifier itself.
 *  3. All channels share the single GatewayConfig configuration object.
 */
public class Notifier {

    private final List<NotificationChannel> channels = new ArrayList<>();
    private final GatewayConfig config;

    public Notifier() {
        // every Notifier reads from the ONE shared configuration instance
        this.config = GatewayConfig.getInstance();
    }

    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public void removeChannel(NotificationChannel channel) {
        channels.remove(channel);
    }

    /** Sends the same message over every registered channel. */
    public void notifyCustomer(String recipient, String message) {
        if (!config.isGatewayEnabled()) {
            System.out.println("Gateway disabled via GatewayConfig - notification skipped.");
            return;
        }
        for (NotificationChannel channel : channels) {
            channel.send(recipient, message);
        }
    }
}
