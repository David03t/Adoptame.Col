/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author DAVID
 */
public class UsuarioBeanValidation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return UsuarioBean.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UsuarioBean persona = (UsuarioBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombrep", "required.nombrep", "¡El Campo Nombre es Obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidop", "required.apellidop", "¡El Campo Apellido es Obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefonop", "required.telefonop", "¡El Campo Telefono es Obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correop", "required.correop", "¡El Campo Correo es Obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edadp", "required.edadp", "¡El Campo Edad es Obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccionp", "required.direccionp", "¡El Campo Direccion es Obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ciudadp", "required.ciudadp", "¡El Campo Ciudad es Obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "generop", "required.generop", "¡El Campo es Genero Obligatorio!");
    }
    
}
