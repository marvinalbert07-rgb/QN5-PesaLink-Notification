public class WhatsAppChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[WHATSAPP] to " + recipient + ": " + message);
    }

    @Override
    public String getChannelName() {
        return "WHATSAPP";
    }
}
