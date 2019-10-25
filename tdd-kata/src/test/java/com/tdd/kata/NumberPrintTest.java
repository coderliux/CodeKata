package com.tdd.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumberPrintTest {
    @Test
    public void should_print_normal_number() {
        String result = NumberPrint.print(1);
        assertThat(result, is("1"));
    }

    @Test
    public void should_print_fizz_with3() {
        assertThat(NumberPrint.print(3), is("Fizz"));
    }

    @Test
    public void should_print_buzz_with5() {
        assertThat(NumberPrint.print(5), is("Buzz"));
    }

    @Test
    public void should_print_fizzbuzz_with15() {
        assertThat(NumberPrint.print(15), is("FizzBuzz"));
    }
}
