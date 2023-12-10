package com.jolt.joltapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class JoltController {

    @Autowired
    JoltProcessor joltProcessor;

    @PostMapping(value = "/processData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> processData(@RequestBody Map<String, Object> data) {
        try {
            // Call the service method to process the data
            Object input = data.get("jsoninput");
            Object spec = data.get("jsonspec");
            Object output = joltProcessor.process(input, spec);
            return new ResponseEntity<>(output, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            e.printStackTrace();
            return new ResponseEntity<>("Error processing data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }



}
