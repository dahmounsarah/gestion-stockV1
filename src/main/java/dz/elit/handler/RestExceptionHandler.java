package dz.elit.handler;

import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import org.apache.log4j.spi.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
// on pas besoin d'ajoute la methode body dans chaque reponse
//ResponseEntityExceptionHandler les request sans reponse
// ( pour la gestion des exception )
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerException(EntityNotFoundException exception,
                                                     WebRequest request){
        final HttpStatus notFound=HttpStatus.NOT_FOUND;
        final ErrorDto errorDto=
         ErrorDto.builder().code(exception.getErrorCodes()).
                codehttp(notFound.value()).message(exception.getMessage()).build();
        return new ResponseEntity<>(errorDto,notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handlerException(InvalidEntityException exception,
                                                     WebRequest request){
        final HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto=
                ErrorDto.builder().code(exception.getErrorCodes()).
                        codehttp(badRequest.value()).message(exception.getMessage()).errors(exception.getErrors()).build();
        return new ResponseEntity<>(errorDto,badRequest);
    }

// les erreurs d'authtification
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDto> handleException(BadCredentialsException exception, WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;// error 400
        final ErrorDto errorDto = ErrorDto.builder()
                .code(ErrorCodes.BAD_CREDENTIALS)
                .codehttp(badRequest.value())
                .message(exception.getMessage())
                .errors(Collections.singletonList("Mot de pass incorrect "))
                // creation dasn REStaticUtil.LOGIN_MOT_PASSE_INCORCTpour les messages
                .build();
        return new ResponseEntity<>(errorDto,badRequest);
    }

}
