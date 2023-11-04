package com.t1consulting.counter.service.impl;

import com.t1consulting.counter.service.FrequencyCounterService;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Service
public class FrequencyCounterServiceImpl implements FrequencyCounterService {

    /**
     *
     * Метод подсчитывает частоту встречаемости каждого символа
     * в строке.
     *
     * Результат отсортирован по частоте встречаемости.
     * Если символы встречаются одинаковое количество раз, они
     * будут упорядочены по алфавиту.
     *
     * @param str - строка, в которой производится подсчет
     * @return отсортированные пары 'символ'-'частота встречаемости'
     */
    @Override
    public LinkedHashMap<Character, Integer> countCharacterFrequency(@NonNull String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return collectResultToSortedMap(map);
    }


    private LinkedHashMap<Character, Integer> collectResultToSortedMap(HashMap<Character, Integer> map) {
        return map.keySet().stream()
                .sorted((x, y) -> {
                    if (map.get(y) - map.get(x) == 0) {
                        return x.compareTo(y);
                    }
                    return map.get(y) - map.get(x);
                })
                .collect(Collectors.toMap(Function.identity(), map::get, (x, y) -> x, LinkedHashMap::new));
    }
}
