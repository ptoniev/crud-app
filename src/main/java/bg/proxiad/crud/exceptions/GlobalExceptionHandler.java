package bg.proxiad.crud.exceptions;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointerException()
    {
        return "nullpointerexception";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleAnyException(){
        return "exception";
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public String RecordNotFoundException()
    {
        return "errorLogin";
    }

    @InitBinder
    public void dateBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }
}
