package helper

class NotificationSenderProvider {
	public static var NotificationSender notificationSender
	
	static def void setNotificationSender(NotificationSender aNotificationSender) {
	 notificationSender = aNotificationSender
	}
}