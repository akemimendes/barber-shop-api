package com.barbershop.barbershop.exception;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;


@Log4j2
@ControllerAdvice
public class BarberShopExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaught(final Exception ex, final WebRequest request){
        log.error("handleUncaught: ", ex);
        return ResponseEntity.badRequest().body(Map.of("erro", ex.getMessage()));
    }

}


