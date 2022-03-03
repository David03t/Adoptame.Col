/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.MascotaBean;
import models.MascotaBeanValidation;
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
    @RequestMapping(value = "mascotas.htm")
@Controller
public class mascotaController {
        private MascotaBeanValidation vistamascotas;
        public mascotaController(){
            this.vistamascotas = new MascotaBeanValidation();
        }
        
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView masform(){
    return new ModelAndView("views/mascotas", "mascotas", new MascotaBean());
    }
    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView vistamascotas (
            @ModelAttribute("mascotas")
            MascotaBean masform,
            BindingResult result,
            SessionStatus status){
        this.vistamascotas.validate("mascctas", result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("mascotas", new MascotaBean());
            mav.setViewName("viewa/mascotas");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.setViewName("viewa/vistaMascotas");
            mav.addObject("nombre", masform.getNombre());
            mav.addObject("categoria", masform.getCategoria());
            mav.addObject("raza", masform.getRaza());
            mav.addObject("edad", masform.getEdad());
            mav.addObject("descripcion", masform.getDescripcion());
            mav.addObject("genero", masform.getGenero());
            return mav;
        }
    }
}
