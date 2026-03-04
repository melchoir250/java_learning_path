package hw_12_unit_test.task_05_leap_year;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LeapYearCheckerTest {
    // Обычные невисокосные годы: 2019, 2021, 2022 → false
    // Високосные годы: 2020, 2000, 1600 → true
    // Года, делящиеся на 100, но не на 400: 1900, 2100 → false
    // Граничные случаи: 0, 4, 400 → true

    private final LeapYearChecker leapYearChecker = new LeapYearChecker();

    @ParameterizedTest
    @ValueSource(ints = {2019, 2021, 2022})
    public void shouldReturnFalseForCommonYears(int year) {
        assertFalse(leapYearChecker.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {2020, 2000, 1600})
    public void shouldReturnTrueForLeapYears(int year) {
        assertTrue(leapYearChecker.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {1900, 2100})
    public void shouldReturnFalseForCenturyYearsNotDivisibleBy400(int year) {
        assertFalse(leapYearChecker.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 400, 4})
    public void shouldHandleBoundaryLeapYears(int year) {
        assertTrue(leapYearChecker.isLeapYear(year));
    }
}
