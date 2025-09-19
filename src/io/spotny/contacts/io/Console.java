package io.spotny.contacts.io;

import java.util.List;

public class Console {

    public static final int LINE_MAX_CHARS = 80;

    public static void line(char c) {
        System.out.print("+");
        for (int i = 0; i < LINE_MAX_CHARS - 2; i++) {
            System.out.print(c);
        }
        System.out.println("+");
    }

    public static void title(String title) {
        line('=');
        System.out.print("|");
        int padding = ((LINE_MAX_CHARS - 2) / 2) - (title.length() / 2);

        if (title.length() % 2 == 0) {
            spaces(padding);
        } else {
            spaces(padding - 1);
        }
        System.out.print(title.toUpperCase());
        spaces(padding);
        System.out.println("|");
        line('=');
    }

    public static void centerText(String text) {
        System.out.print("|");
        int padding = ((LINE_MAX_CHARS - 2) / 2) - (text.length() / 2);
        if (text.length() % 2 == 0) {
            spaces(padding);
        } else {
            spaces(padding - 1);
        }
        System.out.print(text);
        spaces(padding);
        System.out.println("|");
    }

    public static void inputOption(String prompt) {
        System.out.print("| ");
        System.out.print(prompt);
        System.out.print(" " );
    }

    public static void text(String text) {
        System.out.print("| ");
        System.out.print(text);

        var padding = LINE_MAX_CHARS - 3 - text.length();
        spaces(padding);
        System.out.println("|");
    }

    public static void spaces(int num) {
        for (int i = 0; i < num; i++) {
            System.err.print(" ");
        }
    }

    public static void list(List list) {
        line('-');
        for (var item : list) {
            var line = String.format("| %d | %s |",list.indexOf(item), item.toString());
            System.out.print(line);
            spaces(LINE_MAX_CHARS - line.length()-1);
            System.out.println("|");
            line('-');
        }
    }

    public static void showIntroduction() {
        title("Contact Manager Application");
        centerText("System initialized successfully");
    }

    public static void showTutorial() {
        text("Choose one of the following options");
        text("1. Add a new contact");
        text("2. View all contacts");
        text("3. Search for a contact");
        text("4. Delete a contact");
        text("5. Export contacts to CSV");
        text("6. Exit the application");
    }

    public static void invalidCommand() {
        text("Invalid command. Please try again.");
    }

    public static void showTurnOff() {
        text("Turning off the application...");
    }

    public static void exportCompleted() {
        text("Export completed successfully.");
    }

    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
