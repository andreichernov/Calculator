package ru.andreichernov.acicalc.math.operand;

public class Cyrillic extends BaseOperand {
    //А, В, Є, Ѳ, Н, Ѯ, Ѱ, ЦҀѲ etc.
    // http://chikungunya.livejournal.com/10364.html
    // http://www.unicode.org/charts/PDF/U0400.pdf
    private final static Integer[] valuesCodepointArray = {};

    public Cyrillic() {
        super(Cyrillic.valuesCodepointArray);
    }
}
