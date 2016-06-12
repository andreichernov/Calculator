package ru.andreichernov.acicalc;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.slf4j.LoggerFactory.getLogger;

public class ConsoleHelper {
    private static final Logger LOG = getLogger(ConsoleHelper.class);

    private static BufferedReader consoleReader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String readedString = "";
        try {
            readedString = consoleReader.readLine();
            if (readedString.equalsIgnoreCase("exit")) {
                String msg = "Data input was interrupted by user";
                LOG.debug(msg);
                throw new InterruptOperationException(msg);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
        return readedString;
    }

    static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            writeMessage("choose operation: 1 - INFO, 2 - CALC, 3 - EXIT ->");
            String line = readString();
            if (checkWithRegExp(line)){
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            }
            else{
                String msg = "Invalid operation";
                LOG.error(msg);
                writeMessage(msg);
            }
        }

    }

    static boolean checkWithRegExp(String operation)
    {
        Pattern p = Pattern.compile("^[1-3]$");
        Matcher m = p.matcher(operation);
        return m.matches();
    }

}
