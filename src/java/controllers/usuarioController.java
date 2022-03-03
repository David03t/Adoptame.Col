/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.UsuarioBean;
import models.UsuarioBeanValidation;
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

@Controller
public class usuarioController {
        private UsuarioBeanValidation vistapersonas; 
    
        public usuarioController(){
            this.vistapersonas = new UsuarioBeanValidation();
        }
        @RequestMapping(value = "personas.htm",method = RequestMethod.GET)
    public ModelAndView form(){
    
    return new ModelAndView("views/personas", "persona", new UsuarioBean());
    }
    @RequestMapping(value = "personas.htm",method = RequestMethod.POST)
    public ModelAndView vistapersonas (
            @ModelAttribute("persona") UsuarioBean perform,
            BindingResult result,
            SessionStatus status){
        this.vistapersonas.validate(perform, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("personas", new UsuarioBean());
            mav.setViewName("views/personas");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.setViewName("views/vistaPersonas");
            mav.addObject("nombrep",perform.getNombrep());
            mav.addObject("apellidop",perform.getApellidop());
            mav.addObject("telefonop",perform.getTelefonop());
            mav.addObject("correop", perform.getCorreop());
            mav.addObject("edadp",perform.getEdadp());
            mav.addObject("direccionp", perform.getDireccionp());
            mav.addObject("ciudadp",perform.getCiudadp());
            mav.addObject("generop",perform.getGenerop());
            return mav;
        }   
    }
}
