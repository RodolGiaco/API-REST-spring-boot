package com.kube.rodo.exceptions;


import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody //Indica que esta excepcion, al lanzarse desde algun controlador formara parte de la respuesta de la peticion
@ResponseStatus(HttpStatus.NOT_FOUND) // Al lanzarse esta excepcion se reportara con un codigo de respuesta 404
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
