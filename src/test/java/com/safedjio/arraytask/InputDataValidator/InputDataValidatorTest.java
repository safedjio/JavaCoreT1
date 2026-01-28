package com.safedjio.arraytask.InputDataValidator;

import com.safedjio.arraytask.validator.InputDataValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputDataValidatorTest {
    @Test
    void isValidLine_CorrectString_ReturnsTrue() {
        assertTrue(InputDataValidator.isValidLine("1 2 3"));
        assertTrue(InputDataValidator.isValidLine("1, 2, 3"));
        assertTrue(InputDataValidator.isValidLine("10 - 20 - 30"));
        assertTrue(InputDataValidator.isValidLine("1; 2; 3"));
        assertTrue(InputDataValidator.isValidLine("1, 2 - 3; 4"));
    }

    @Test
    void isValidLine_InvalidString_ReturnsFalse() {
        assertFalse(InputDataValidator.isValidLine("1z 2 3"));
        assertFalse(InputDataValidator.isValidLine("1 @ 2"));

        assertFalse(InputDataValidator.isValidLine("1.5 2"));
    }

    @Test
    void isValidLine_EmptyOrNull_ReturnsFalse() {
        assertFalse(InputDataValidator.isValidLine(""));
        assertFalse(InputDataValidator.isValidLine("   "));
        assertFalse(InputDataValidator.isValidLine(null));
    }

}