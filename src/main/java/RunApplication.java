import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;

import controllers.DropDownController;

public class RunApplication {

	// Create Drop Down Controller
	private static DropDownController menuController = new DropDownController();

	public static void main(String[] args) {

		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
		}
		final PopupMenu popup = new PopupMenu();
		final TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("resources/images/bulb.gif"));
		final SystemTray tray = SystemTray.getSystemTray();

		// Create a pop-up menu components
		MenuItem aboutItem = new MenuItem("About");
		MenuItem startOption = new MenuItem("Start Work Record");
		MenuItem stopOption = new MenuItem("Stop Work Record");
		MenuItem taskManager = new MenuItem("Task Manger");
		MenuItem quitItem = new MenuItem("Quit");

		// Add components to pop-up menu
		popup.add(aboutItem);
		popup.addSeparator();
		popup.add(startOption);
		popup.add(stopOption);
		popup.addSeparator();
		popup.add(taskManager);
		popup.add(quitItem);

		// Add action listeners to give the options their functionality
		startOption.addActionListener((ActionEvent e) -> menuController.startRecord());
		stopOption.addActionListener((ActionEvent e) -> menuController.endRecord());
		taskManager.addActionListener((ActionEvent e) -> StartApplicationGUI.main(new String[] {}));
		quitItem.addActionListener((ActionEvent e) -> System.exit(0));

		trayIcon.setPopupMenu(popup);

		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
		}
	}

}
