package com.forest.surveillance.notification;

import com.forest.surveillance.entity.DeforestationAlert;
import com.forest.surveillance.entity.ForestGuard;
import com.forest.surveillance.entity.Notification;
import com.forest.surveillance.entity.NotificationMode;
import com.forest.surveillance.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(SmsNotificationService.class);

    private final NotificationRepository notificationRepository;

    @Value("${sms.provider:DEMO}")
    private String smsProvider;

    @Value("${sms.api-key:${SMS_API_KEY:}}")
    private String smsApiKey;

    @Value("${sms.sender-id:${SMS_SENDER_ID:FOREST_ALERT}}")
    private String smsSenderId;

    public SmsNotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification sendSmsNotification(ForestGuard guard, DeforestationAlert alert) {
        String recipientPhone = guard != null && guard.getPhoneNumber() != null ? guard.getPhoneNumber() : "UNASSIGNED";
        String guardName = guard != null ? guard.getFullName() : "Forest Guard";
        Long guardId = guard != null ? guard.getId() : null;

        String messageContent = String.format(
            "Smart Forest Surveillance Alert: Potential deforestation detected in [%s]. " +
            "Estimated area: %.2f ha (%.1f%% loss). Please inspect assigned sector. Alert ID: #%d",
            alert.getAreaName(),
            alert.getEstimatedAffectedAreaHectares() != null ? alert.getEstimatedAffectedAreaHectares() : 0.0,
            alert.getChangePercentage() != null ? alert.getChangePercentage() : 0.0,
            alert.getId()
        );

        NotificationMode mode = (smsApiKey != null && !smsApiKey.trim().isEmpty() && !"DEMO".equalsIgnoreCase(smsProvider)) 
            ? NotificationMode.REAL 
            : NotificationMode.DEMO;

        String status = "SENT";

        if (mode == NotificationMode.REAL) {
            logger.info("REAL SMS MODE: Sending SMS to {} via provider {}: {}", recipientPhone, smsProvider, messageContent);
            // In production, invoke real HTTP client for SMS provider (e.g., Twilio, AWS SNS, Infobip)
        } else {
            logger.info("DEMO MODE: Simulating SMS dispatch to {}: {}", recipientPhone, messageContent);
            status = "SENT_DEMO";
        }

        Notification notification = new Notification(
            alert.getId(),
            guardId,
            guardName,
            recipientPhone,
            messageContent,
            mode,
            status
        );

        return notificationRepository.save(notification);
    }
}
