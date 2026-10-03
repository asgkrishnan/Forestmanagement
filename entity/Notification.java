package com.forest.surveillance.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alert_id", nullable = false)
    private Long alertId;

    private Long recipientGuardId;
    private String recipientGuardName;
    private String recipientPhone;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationMode mode = NotificationMode.DEMO;

    private String deliveryStatus = "SENT";

    private LocalDateTime sentTimestamp = LocalDateTime.now();

    public Notification() {
    }

    public Notification(Long alertId, Long recipientGuardId, String recipientGuardName, String recipientPhone, String message, NotificationMode mode, String deliveryStatus) {
        this.alertId = alertId;
        this.recipientGuardId = recipientGuardId;
        this.recipientGuardName = recipientGuardName;
        this.recipientPhone = recipientPhone;
        this.message = message;
        this.mode = mode;
        this.deliveryStatus = deliveryStatus;
        this.sentTimestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    public Long getRecipientGuardId() {
        return recipientGuardId;
    }

    public void setRecipientGuardId(Long recipientGuardId) {
        this.recipientGuardId = recipientGuardId;
    }

    public String getRecipientGuardName() {
        return recipientGuardName;
    }

    public void setRecipientGuardName(String recipientGuardName) {
        this.recipientGuardName = recipientGuardName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationMode getMode() {
        return mode;
    }

    public void setMode(NotificationMode mode) {
        this.mode = mode;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getSentTimestamp() {
        return sentTimestamp;
    }

    public void setSentTimestamp(LocalDateTime sentTimestamp) {
        this.sentTimestamp = sentTimestamp;
    }
}
