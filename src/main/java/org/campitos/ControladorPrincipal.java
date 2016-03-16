package org.campitos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by campitos on 18/11/15.
 */
@Controller
@RequestMapping("/")
public class ControladorPrincipal {
    @RequestMapping(value="/hola", method= RequestMethod.GET, headers={"Accept=text/html"})
    @ResponseBody String inicial(){
        return "Bienvenido";
    }
    @RequestMapping("/")
    public String inicio(){

        return "inicio.html";
    }

}
