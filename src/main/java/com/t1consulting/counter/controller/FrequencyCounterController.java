package com.t1consulting.counter.controller;

import com.t1consulting.counter.service.FrequencyCounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.LinkedHashMap;

@Log4j2
@RestController
@RequiredArgsConstructor
public class FrequencyCounterController { 

    private final FrequencyCounterService counterService;

    @PostMapping("frequencyCounter/count")
    public ResponseEntity<LinkedHashMap<Character, Integer>> countCharacterFrequency(@RequestBody String str) {
        return ResponseEntity.ok(counterService.countCharacterFrequency(str));
    }
}
