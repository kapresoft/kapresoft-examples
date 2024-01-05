package com.kapresoft.articles.commonapp;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamCollectorTest {

    @Test
    void streamShouldAccumulateList_UsingTheStandardWay() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> collectedNumbers = numbers.stream()
                .filter(i -> i > 2).collect(Collectors.toList());
        assertThat(collectedNumbers).containsExactlyInAnyOrder(3, 4, 5);
    }

    @Test
    void streamShouldAccumulateList_UsingTheNewWay() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        // As List
        List<Integer> collectedNumbers = numbers.stream()
                .filter(i -> i > 2).toList();
        assertThat(collectedNumbers).containsExactlyInAnyOrder(3, 4, 5);

        // As Array
        Integer[] collectedNumbersArr = numbers.stream()
                .filter(i -> i > 3).toArray(Integer[]::new);
        assertThat(collectedNumbersArr).containsExactlyInAnyOrder(4, 5);
    }

}
