package org.campitos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by campitos on 5/21/15.
 * api key: AIzaSyDeDwyXm8mG_EwBtqsaS98z1FGqoqc2BRM
 */
@Controller
public class ControladorMensajes {
    @RequestMapping(value="/hola", method = RequestMethod.GET, headers = {"Accept=text/html"})
    @ResponseBody
    String hola(){

        return "Hola a los mensajes gcm";
    }
}
