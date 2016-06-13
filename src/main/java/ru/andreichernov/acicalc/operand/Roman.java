package ru.andreichernov.acicalc.operand;

import java.util.List;

/**
 *
 */
public class Roman extends BaseOperand{
    //https://en.wikipedia.org/wiki/Numerals_in_Unicode#Roman_numerals
    private final static String[] VALUES_CHAR_ARRAY = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final static Integer[] ARAB_EQUIVALENT = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public Roman() {
        super(Roman.VALUES_CHAR_ARRAY);
    }

    @Override
    public int toDecimal() {
        List<Integer> listOfCodepoints = super.getNumber();
        StringBuilder roman = new StringBuilder();
        for (Integer codepoint : listOfCodepoints) {
            roman.appendCodePoint(codepoint);
        }
        return rometoArab(roman.toString());
    }

    private int rometoArab(String rome) {
        /** Преобразуем к верхнему регистру */
        StringBuilder rome4conv = new StringBuilder(rome.toUpperCase());
        int arabNumber = 0, i = 0;
        /** Проверяем переданную строку на наличие символов */
        if (rome4conv.length() > 0) {
            while (true) {
                do {
                    if (VALUES_CHAR_ARRAY[i].length() <= rome4conv.length()) {
                        // Выделяем из строки подстроку и сравниваем со
                        // значением из массива Arab
                        if (VALUES_CHAR_ARRAY[i].equals(rome4conv.substring(0, VALUES_CHAR_ARRAY[i].length()))) {
                            // После чего прибавляем число соответствующее
                            // индексу элемента римской цифры из массива ArabBase
                            arabNumber += ARAB_EQUIVALENT[i];
                            // и удаляем из строки римскую цифру
                            rome4conv.delete(0, VALUES_CHAR_ARRAY[i].length());
                            if (rome4conv.length() == 0) {
                                return arabNumber;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } while (rome4conv.length() != 0);
                i++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
