package bg.proxiad.crud.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = NullPointerException.class)
  public String handleNullPointerException() {
    return "nullpointerexception";
  }

  //    @ExceptionHandler(value = Exception.class)
  //    public String handleAnyException(){
  //        return "exception";
  //    }

  @ExceptionHandler(value = RecordNotFoundException.class)
  public String RecordNotFoundException() {
    return "errorLogin";
  }
}
