package ru.andreichernov.acicalc.cleaners;

import ru.andreichernov.acicalc.exception.WrongExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmptyCharacterCleaner implements ExpCleaner {

    /**
     * Удаляет все незначащие символы из исходной строки (пробелы)
     *
     * @return Очищенное от лишних символов выражение
     */
    @Override
    public String clean(final String dirtyExpression) {
        if (dirtyExpression == null || dirtyExpression.length() == 0) {
            try {
                throw new WrongExpression("No expression has been specified.");
            } catch (WrongExpression wrongExpression) {
                wrongExpression.printStackTrace();
            }
        }
        Pattern p = Pattern.compile("\\s");
        return p.matcher(dirtyExpression).replaceAll("");
    }
}
