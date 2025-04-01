package main.java.singleton.logger_system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static volatile Logger instance = null;
    private PrintWriter writer;

    private Logger() {
        setFileName("default_log.txt");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public synchronized void setFileName(String newFileName) {
        if (writer != null) {
            writer.close();
        }

        try {
            FileWriter fileWriter = new FileWriter(newFileName, true);
            writer = new PrintWriter(fileWriter, true);
        } catch (IOException e) {
            System.err.println("Error: Could not open log file: " + newFileName);
        }
    }

    public synchronized void write(String message) {
        if (writer != null) {
            writer.println(message);
        } else {
            System.err.println("Error: No writer found.");
        }
    }

    public synchronized void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}
