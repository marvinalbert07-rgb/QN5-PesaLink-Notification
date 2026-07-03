public class SmsChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS] to " + recipient + ": " + message);
    }

    @Override
    public String getChannelName() {
        return "SMS";
    }
}
