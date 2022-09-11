package com.cash.history.utils;

import org.junit.jupiter.api.Test;

import static com.cash.history.utils.Coalescing.firstNotNull;
import static org.junit.jupiter.api.Assertions.*;

class CoalescingTest {

    @Test
    void firstNotNull_MustReturnSecondValue_Test() {
        String defaultValue = "value";
        String expectedValue = "value";
        String result = firstNotNull(null, defaultValue);

        assertEquals(result, expectedValue);
    }

    @Test
    void firstNotNull_MustReturnFirstValue_Test() {
        String defaultValue = "value";
        String nonEmptyValue1 = "non empty value";
        String nonEmptyValue2 = "non empty value 2";
        String expectedValue = "non empty value";
        String result = firstNotNull(nonEmptyValue1, nonEmptyValue2, defaultValue);

        assertEquals(result, expectedValue);
    }

    @Test
    void firstNotNull_MustReturnThirdValue_Test() {
        String defaultValue = "value";
        String expectedValue = "value";
        String result = firstNotNull(null, null, defaultValue);

        assertEquals(result, expectedValue);
    }
}