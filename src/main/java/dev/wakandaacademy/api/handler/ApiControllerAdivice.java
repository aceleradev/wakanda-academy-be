package dev.wakandaacademy.api.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.resource.HttpResource;

import dev.wakandaacademy.api.domain.ApiErrorResponse;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.EntityExistsException;
import dev.wakandaacademy.api.exception.NotFoundException;

@RestControllerAdvice
@ControllerAdvice
public class ApiControllerAdivice {
	private static final Logger log = LoggerFactory.getLogger(ApiControllerAdivice.class);
    private ApiErrorResponseExceptionExtractor apiErrorResponseExceptionExtractor;

    public ApiControllerAdivice(ApiErrorResponseExceptionExtractor apiErrorResponseExceptionExtractor) {
        this.apiErrorResponseExceptionExtractor = apiErrorResponseExceptionExtractor;
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(ApiException ex) {
    	log.error("Error:",ex);
        ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, ex.getCode());
        return ResponseEntity.status(apiErrorResponse.getCode().intValue()).body(apiErrorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException ex) {
    	log.error("Error:",ex);
        ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorResponse);
    }
    
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiErrorResponse> handleAuthenticationException(AuthenticationException ex) {
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.BAD_REQUEST.value());
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusinessException(BusinessException ex) {
    	log.error("Error:",ex);
        ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }
    
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleEntityExistsException(EntityExistsException ex) {
    	log.error("Error:",ex);
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, EntityExistsException.ENTITY_EXISTS_STATUS_CODE);
    	return ResponseEntity.status(EntityExistsException.ENTITY_EXISTS_STATUS_CODE).body(apiErrorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
    	log.error("Error:",ex);
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorResponse);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiErrorResponse> handleInternalError(HttpRequest req, HttpResource res, Exception ex) {
    	log.error("Error:",ex);
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(HttpRequest req, HttpResource res, BadRequest ex) {
    	log.error("Error:",ex);
    	ApiErrorResponse apiErrorResponse = this.apiErrorResponseExceptionExtractor.getApiResponse(ex, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }
}