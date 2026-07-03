/**
 * Common contract for every delivery channel (SMS, Email, Push, WhatsApp,
 * or any future channel). New channels are added by writing a new class
 * that implements this interface - no existing code has to change.
 */
public interface NotificationChannel {
    void send(String recipient, String message);
    String getChannelName();
}
