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
public class usuario_mascotaBeanValidation implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return usuario_mascotaBean.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        usuario_mascotaBean usuario_mascota = (usuario_mascotaBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id_usuario", "required.id_usuario", "¡El campo ID de Usuario es requerido!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id_mascota", "required.id_mascota", "¡El campo ID de Mascota es requerido!");
    }
    
}
