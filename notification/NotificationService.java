package com.forest.surveillance.notification;

import com.forest.surveillance.entity.DeforestationAlert;
import com.forest.surveillance.entity.ForestGuard;
import com.forest.surveillance.entity.Notification;

public interface NotificationService {
    Notification sendSmsNotification(ForestGuard guard, DeforestationAlert alert);
}
