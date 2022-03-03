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
public class MascotaBeanValidation implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return MascotaBean.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MascotaBean mascota = (MascotaBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "¡El campo Nombre es requerido!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoria", "required.categoria", "¡El campo Categoria es requerido!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "raza", "required.raza", "¡El campo Raza es requerido!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edad", "required.edad", "¡El campo Edad es requerido!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "required.descripcion", "¡El campo Descripcion es requerido!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genero", "required.genero", "¡El campo Genero es requerido!");
    }
    
}
