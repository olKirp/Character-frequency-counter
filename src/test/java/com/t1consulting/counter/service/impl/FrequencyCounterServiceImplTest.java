package com.t1consulting.counter.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FrequencyCounterServiceImplTest {

    @InjectMocks
    FrequencyCounterServiceImpl service;

    @Test
    void givenNormalString_thenSortInFrequencyOrder() {
        String s = "abbcccdd";

        LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('c', 3);
        expected.put('b', 2);
        expected.put('d', 2);
        expected.put('a', 1);

        LinkedHashMap<Character, Integer> result = service.countCharacterFrequency(s);
        assertTrue(mapsEqualsWithOrder(expected, result));
    }

    @Test
    void givenOneCharacter_thenReturnMapWithOneElement() {
        String s = "a";

        LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);

        LinkedHashMap<Character, Integer> result = service.countCharacterFrequency(s);
        assertTrue(mapsEqualsWithOrder(expected, result));
    }

    @Test
    void givenCharsWithSameFrequency_thenSortInAlphabetOrder() {
        String s = "cbad";

        LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);
        expected.put('d', 1);

        LinkedHashMap<Character, Integer> result = service.countCharacterFrequency(s);
        assertTrue(mapsEqualsWithOrder(expected, result));
    }

    @Test
    void givenEmptyString_thenReturnEmptyMap() {
        String s = "";

        LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();

        LinkedHashMap<Character, Integer> result = service.countCharacterFrequency(s);
        assertTrue(mapsEqualsWithOrder(expected, result));
    }

    @Test
    void givenNull_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> service.countCharacterFrequency(null));
    }

    boolean mapsEqualsWithOrder( LinkedHashMap<Character, Integer> expected, LinkedHashMap<Character, Integer> result) {
        Iterator<Map.Entry<Character, Integer>> leftItr = expected.entrySet().iterator();
        Iterator<Map.Entry<Character, Integer>> rightItr = result.entrySet().iterator();

        while ( leftItr.hasNext() && rightItr.hasNext()) {
            Map.Entry<Character, Integer> leftEntry = leftItr.next();
            Map.Entry<Character, Integer> rightEntry = rightItr.next();

            if (! leftEntry.equals(rightEntry))
                return false;
        }
        return !(leftItr.hasNext() || rightItr.hasNext());
    }
    
}