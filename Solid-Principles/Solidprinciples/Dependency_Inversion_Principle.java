package Solidprinciples;

public class Dependency_Inversion_Principle {
	public static void main(String[] args) {
		Notification notification = new EmailNotification();
		Notifier notifier = new Notifier(notification);
		notifier.notifyUser();
	}
}

interface Notification {
	void notifyUser();
}

class EmailNotification implements Notification {
	@Override
	public void notifyUser() {
		System.out.println("Notifying via email...");
	}
}

class Notifier {
	private Notification notification;

	public Notifier(Notification notification) {
		this.notification = notification;
	}

	public void notifyUser() {
		notification.notifyUser();
	}
}