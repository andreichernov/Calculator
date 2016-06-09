package ru.andreichernov.acicalc;

import ru.andreichernov.acicalc.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper {
    private static BufferedReader consoleReader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String message = "";
        try {
            message = consoleReader.readLine();
            if (message.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {

        }
        return message;
    }

    static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            writeMessage("choose operation: 1 - INFO, 2 - CALC, 3 - EXIT ->");
            String line = readString();
            if (checkWithRegExp(line))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage("invalid date");
        }

    }

    static boolean checkWithRegExp(String operation)
    {
        Pattern p = Pattern.compile("^[1-3]$");
        Matcher m = p.matcher(operation);
        return m.matches();
    }

}
