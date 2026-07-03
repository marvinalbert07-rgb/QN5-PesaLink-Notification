/**
 * GatewayConfig - Singleton design pattern.
 * Exactly ONE instance exists for the whole running application, and every
 * part of the Notification module reads its settings from that one object.
 *
 * Lazy instantiation: the object is only created the first time it is
 * needed (getInstance() is called), not when the class is loaded.
 *
 * Thread-safety: double-checked locking with a volatile field so that
 * concurrent threads calling getInstance() at the same time still only
 * ever get one instance, without paying the cost of synchronizing on
 * every single call.
 */
public class GatewayConfig {

    // volatile: guarantees visibility of the fully-constructed instance
    // to all threads once assigned, and prevents unsafe instruction reordering.
    private static volatile GatewayConfig instance;

    private boolean gatewayEnabled;
    private String smsProviderKey;
    private String emailProviderKey;
    private int retryLimit;

    // Private constructor: no other class can call "new GatewayConfig()".
    private GatewayConfig() {
        // default configuration - in a real system this would be loaded
        // from a properties file, environment variables, or a database
        this.gatewayEnabled = true;
        this.smsProviderKey = "DEFAULT_SMS_KEY";
        this.emailProviderKey = "DEFAULT_EMAIL_KEY";
        this.retryLimit = 3;
    }

    public static GatewayConfig getInstance() {
        GatewayConfig result = instance;
        if (result == null) {                    // first check (no locking - fast path)
            synchronized (GatewayConfig.class) {
                result = instance;
                if (result == null) {             // second check (inside the lock)
                    instance = result = new GatewayConfig();
                }
            }
        }
        return result;
    }

    public boolean isGatewayEnabled() {
        return gatewayEnabled;
    }

    public void setGatewayEnabled(boolean gatewayEnabled) {
        this.gatewayEnabled = gatewayEnabled;
    }

    public String getSmsProviderKey() {
        return smsProviderKey;
    }

    public String getEmailProviderKey() {
        return emailProviderKey;
    }

    public int getRetryLimit() {
        return retryLimit;
    }

    public void setRetryLimit(int retryLimit) {
        this.retryLimit = retryLimit;
    }
}
