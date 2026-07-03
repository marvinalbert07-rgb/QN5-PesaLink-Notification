public class EmailChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[EMAIL] to " + recipient + ": " + message);
    }

    @Override
    public String getChannelName() {
        return "EMAIL";
    }
}
