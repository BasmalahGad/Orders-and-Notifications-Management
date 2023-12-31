package com.onm.ordersandnotificationsmanagement.notifications.services;

import com.onm.ordersandnotificationsmanagement.accounts.models.Account;
import com.onm.ordersandnotificationsmanagement.notifications.models.Notification;
import com.onm.ordersandnotificationsmanagement.notifications.models.NotificationTemplate;

/**
 * The type Sms channel.
 */
public class SMSNotifierDecorator extends NotifierDecorator {
    /**
     * Instantiates a new Sms notifier decorator.
     *
     * @param notifier the notifier
     */
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    /**
     * send notification via sms
     * @param notification the notification
     * @param account      the account
     * @return
     */
    @Override
    public String sendNotification(Notification notification, Account account) {
        storeNotifiedPhoneNumber(account);
        return super.sendNotification(notification, account) + "Sent From SMS -";
    }

    /**
     * store the notified phone number
     * @param account
     */
    private void storeNotifiedPhoneNumber(Account account) {
        if(NotificationTemplate.mostNotified.get(account.getPhoneNumber())==null)
            NotificationTemplate.mostNotified.put(account.getPhoneNumber(),0);
        else
            NotificationTemplate.mostNotified.put(account.getPhoneNumber(),
                    NotificationTemplate.mostNotified.get(account.getPhoneNumber())+1);
    }
}