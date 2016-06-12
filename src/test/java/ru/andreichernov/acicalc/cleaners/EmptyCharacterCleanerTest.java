package ru.andreichernov.acicalc.cleaners;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyCharacterCleanerTest {
    @Test
    public void clean() throws Exception {
        ExpCleaner expCleaner = new EmptyCharacterCleaner();
        String dirtyString = "     XVI  +     2 - V   * 4     ";
        String cleanString = "XVI+2-V*4";
        assertEquals(cleanString, expCleaner.clean(dirtyString));
    }

}