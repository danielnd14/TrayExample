package app.gui;

import dorkbox.systemTray.MenuItem;
import dorkbox.systemTray.SystemTray;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public final class TrayMenu {
	private static final Random random = new Random();
	private final SystemTray systemTray;

	public TrayMenu() {
		systemTray = SystemTray.get();
		init();
	}

	private static void printRandomNumber(final String prefix) {
		final var msg = prefix + " {" + random.nextInt() + "}";
		JOptionPane.showMessageDialog(null, msg);
	}

	private void init() {

		if (systemTray == null) {
			throw new RuntimeException("Unable to load SystemTray!");
		} else {
			systemTray.setImage(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Tray.png")));
			final var jSeparator = new JSeparator();

			systemTray.getMenu()
					.add(jSeparator);

			systemTray.getMenu()
					.add(getMenu());

			systemTray.getMenu()
					.add(jSeparator);

			systemTray.getMenu()
					.add(getMenu());

			systemTray.getMenu()
					.add(jSeparator);

			systemTray.getMenu()
					.add(getMenu());

			systemTray.getMenu()
					.add(jSeparator);

			systemTray.getMenu()
					.add(getExitMenu());
		}
	}

	private MenuItem getExitMenu() {
		final MenuItem menu = new MenuItem();
		menu.setText("exit");
		menu.setCallback(e -> System.exit(0));
		return menu;
	}

	private MenuItem getMenu() {
		final var random = new Random();
		final var title = "menu - " + random.nextInt(10);
		final MenuItem menu = new MenuItem();
		menu.setText(title);
		menu.setCallback(e -> printRandomNumber(title));
		return menu;
	}
}
