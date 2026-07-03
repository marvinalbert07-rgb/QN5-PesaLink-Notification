/**
 * (a) Constructor vs Java's garbage collector (used instead of C++ destructors).
 */
public class ConstructorVsGcDemo {

    static class WalletSession {
        private final String customerId;

        // CONSTRUCTOR: runs automatically and immediately when "new" is used.
        // It is deterministic (you know exactly when it fires) and its job
        // is to set an object UP - open resources, set initial state.
        public WalletSession(String customerId) {
            this.customerId = customerId;
            System.out.println("Constructor: session opened for " + customerId);
        }

        // finalize()/GC has NO exact equivalent of a C++ destructor.
        // The garbage collector reclaims memory automatically, but WHEN it
        // runs is not deterministic and is not guaranteed at all.
        @Override
        protected void finalize() {
            System.out.println("Object for " + customerId + " collected at some point (non-deterministic)");
        }
    }

    public static void main(String[] args) {
        WalletSession session = new WalletSession("CUST-001"); // constructor runs NOW
        session = null; // object becomes eligible for GC, but WHEN it is
                         // actually collected is decided by the JVM, not the
                         // programmer - unlike a C++ destructor, which runs
                         // deterministically the instant an object goes out
                         // of scope or is deleted.
        System.gc(); // only a REQUEST/hint to the JVM, not a guarantee
        System.out.println("main() finished");
    }
}
