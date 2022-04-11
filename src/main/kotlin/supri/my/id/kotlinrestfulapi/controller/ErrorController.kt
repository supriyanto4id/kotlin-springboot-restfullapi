package supri.my.id.kotlinrestfulapi.controller

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import supri.my.id.kotlinrestfulapi.error.NotFoundException
import supri.my.id.kotlinrestfulapi.error.UnauthorizedException
import supri.my.id.kotlinrestfulapi.model.WebRespon
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value =[ConstraintViolationException::class])
    fun validationHandler(constrainViolationException:ConstraintViolationException):WebRespon<String>{
        return WebRespon(
            code= 400,
            status ="BAD REQUEST",
             data =constrainViolationException.message!!
        )
    }

    @ExceptionHandler(value =[NotFoundException::class])
    fun notFound(notFoundException: NotFoundException):WebRespon<String>{
        return WebRespon(
            code= 404,
            status ="NOT FOUND",
            data ="Not Found"
        )
    }

    @ExceptionHandler(value =[UnauthorizedException::class])
    fun unauthorized(Unauthorized: UnauthorizedException):WebRespon<String>{
        return WebRespon(
            code= 401,
            status ="UNAUTHORIZED",
            data ="Please put your X-Api-Key"
        )
    }

}