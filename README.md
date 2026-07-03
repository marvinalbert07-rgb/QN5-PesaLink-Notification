# QN5-PesaLink-Notification

Java solution for Question 5 (PesaLink Notification module redesign).

- `NotificationChannel.java` — common interface implemented by every channel.
- `SmsChannel.java`, `EmailChannel.java`, `PushChannel.java`, `WhatsAppChannel.java` — concrete channels (composition, no inheritance between them).
- `Notifier.java` — composed of any number of NotificationChannel objects; sends one message over all registered channels.
- `GatewayConfig.java` — Singleton (lazy, thread-safe) shared configuration object, part (c).
- `TxnList.java` — generic class illustrating the immutability issue discussed in part (d).
- `ConstructorVsGcDemo.java` — part (a): constructor vs garbage collection demo.
- `PesaLinkDemo.java` — end-to-end demo tying it all together.

## Run
```
javac *.java
java PesaLinkDemo
java ConstructorVsGcDemo
```
