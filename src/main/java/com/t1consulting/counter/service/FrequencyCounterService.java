package com.t1consulting.counter.service;

import java.util.LinkedHashMap;

public interface FrequencyCounterService {

    LinkedHashMap<Character, Integer> countCharacterFrequency(String s);

}
