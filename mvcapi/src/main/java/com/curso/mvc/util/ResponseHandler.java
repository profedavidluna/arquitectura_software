package com.curso.mvc.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("code", status.value());
        map.put("status", status.name());
        map.put("data", responseObj);
        return new ResponseEntity<Object>(map, status);
    }
}