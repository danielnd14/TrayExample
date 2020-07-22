package app;

import app.gui.TrayMenu;
import dorkbox.systemTray.SystemTray;

public class TrayApp {
	public static void main(final String[] args) {
		SystemTray.DEBUG = true;
		SystemTray.ENABLE_ROOT_CHECK = false;
		new TrayMenu();
		System.out.println(">>>>>Loaded<<<<<");
	}
}
