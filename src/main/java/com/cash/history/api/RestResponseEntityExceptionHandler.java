package com.cash.history.api;

import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger LOG = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
    @Value("{spring.config.activate.on-profile}")
    String debug;

    @ExceptionHandler(value = {PropertyValueException.class, EmptyResultDataAccessException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        /*
         * Catch the error caused by null values on Income post request
         */
        if (debug.equals("dev")) LOG.error(Arrays.toString(ex.getStackTrace()), ex.getCause()); // DEBUG ONLY
        String bodyOfResponse = ex.getLocalizedMessage();
        var response = Map.of("error", bodyOfResponse.split("; "));
        var status = bodyOfResponse.contains("exists") ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST;
        return handleExceptionInternal(ex, response, new HttpHeaders(), status, request);
    }
}
