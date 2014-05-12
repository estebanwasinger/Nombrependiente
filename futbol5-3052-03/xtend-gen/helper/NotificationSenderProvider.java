package helper;

import helper.NotificationSender;

@SuppressWarnings("all")
public class NotificationSenderProvider {
  public static NotificationSender notificationSender;
  
  public static void setNotificationSender(final NotificationSender aNotificationSender) {
    NotificationSenderProvider.notificationSender = aNotificationSender;
  }
}
