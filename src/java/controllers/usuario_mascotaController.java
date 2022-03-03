/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;


import models.usuario_mascotaBean;
import models.usuario_mascotaBeanValidation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DAVID
 */
    @RequestMapping(value = "adopcion.htm")
@Controller
public class usuario_mascotaController {
        private usuario_mascotaBeanValidation vistaadopcion;
        public usuario_mascotaController(){
            this.vistaadopcion = new usuario_mascotaBeanValidation();
        }
    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView per_masform(){
    return new ModelAndView("views/adopcion", "adopcion", new usuario_mascotaBean());
    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView vistaadopcion(
            @ModelAttribute("adopcion") usuario_mascotaBean per_masform,
            BindingResult result,
            SessionStatus status){
        this.vistaadopcion.validate(per_masform, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("adopcion", new usuario_mascotaBean());
            mav.setViewName("views/adopcion");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.setViewName("views/vistaAdopcion");
            mav.addObject("id_usuario", per_masform.getId_usuario());
            mav.addObject("id_mascota", per_masform.getId_mascota());
            return mav;
        }
    }
}
