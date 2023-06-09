package kodlama.io.rentacar.core.configuration;

import jakarta.validation.ValidationException;
import kodlama.io.rentacar.common.constants.ExceptionTypes;
import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.core.utils.result.ExceptionResult;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ExceptionResult<Object>  handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors=new HashMap<>();
        for(FieldError fieldError:exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
      return new ExceptionResult<>(ExceptionTypes.Exception.Validation,validationErrors);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResult<Object>  handleValidationException(ValidationException exception){
        return new ExceptionResult<>(ExceptionTypes.Exception.Validation,exception.getMessage());
    }



    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ExceptionResult<Object> handleBusinessException(BusinessException exception){
        return new ExceptionResult<>(ExceptionTypes.Exception.Business, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT) //409
    public ExceptionResult<Object> handleDateIntegrityViolationException(DataIntegrityViolationException exception){
        return new ExceptionResult<>(ExceptionTypes.Exception.DataIntegrityViolation,exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //500
    public ExceptionResult<Object> handleBusinessException(RuntimeException exception){
        return new ExceptionResult<>(ExceptionTypes.Exception.Runtime, exception.getMessage());
    }


}
