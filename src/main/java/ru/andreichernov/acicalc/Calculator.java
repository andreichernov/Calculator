package ru.andreichernov.acicalc;


import ru.andreichernov.acicalc.command.CommandExecutor;

import java.util.Locale;

public class Calculator {
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
