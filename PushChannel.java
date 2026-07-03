public class PushChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[PUSH] to " + recipient + ": " + message);
    }

    @Override
    public String getChannelName() {
        return "PUSH";
    }
}
