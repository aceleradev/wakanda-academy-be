package com.aceleradev.api.handler;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.resource.HttpResource;

import com.aceleradev.api.domain.ApiErrorResponse;
import com.aceleradev.api.exception.ApiException;
import com.aceleradev.api.exception.BusinessException;
import com.aceleradev.api.exception.NotFoundException;

@RestControllerAdvice
public class ApiControllerAdivice {

    private ApiErrorResponseExceptionExtractor apiErrorResponseExceptionExtractor;

    public ApiControllerAdivice(ApiErrorResponseExceptionExtractor apiErrorResponseExceptionExtractor) {
        this.apiErrorResponseExceptionExtractor = apiErrorResponseExceptionExtractor;
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(ApiException ex) {
        ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, ex.getCode());
        return ResponseEntity.status(apiErrorResponse.getCode().intValue()).body(apiErrorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException ex) {
        ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusinessException(BusinessException ex) {
        ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorResponse);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiErrorResponse> handleInternalError(HttpRequest req, HttpResource res, Exception ex) {
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(HttpRequest req, HttpResource res, BadRequest ex) {
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }

}

