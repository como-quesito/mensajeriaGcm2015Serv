package org.campitos;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gcm.server.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by campitos on 5/26/15.
 */

@Service
@Transactional
@Controller
public class ControladorRegistroMensajes {
    String key="AIzaSyDeDwyXm8mG_EwBtqsaS98z1FGqoqc2BRM";
    private static final int MULTICAST_SIZE = 1000;
    private Sender sender;
    private static final Executor threadPool = Executors.newFixedThreadPool(5);
@Inject
private ServicioRegistro servicioRegistro;


    @RequestMapping(value="/registro-mensajes", method= RequestMethod.POST, headers={"Accept=application/json;charset=UTF-8"})
    @ResponseBody
    String guardarCliente(@RequestBody String json)throws Exception{
        ObjectMapper mapper=new ObjectMapper();

      String resultado="nada";
        //convertimos jsonsito a un RegistroMensajeria, que asi se supone vienen :)
        RegistroMensajeria registro = mapper.readValue(json,RegistroMensajeria.class );
       //RegistroMensajeria registroMensajeria= new RegistroMensajeria(registroId);
        servicioRegistro.agregarRegistro(registro);
        System.out.println("Registrado con exito"+registro.getRegistroId());
        return "registrado con exito";
    }

    @RequestMapping(value="/enviar/{mensaje}", method= RequestMethod.GET,headers={"Accept=text/html"} )
    @ResponseBody
    public String enviarMensaje(@PathVariable String mensaje){
        sender=new Sender(key);
        String resultado="antes";
        List<RegistroMensajeria> registros=servicioRegistro.getTodos();
        RegistroMensajeria regis=registros.get(0);
        String registroId=regis.getRegistroId();
        Content c=new Content();
        c.addRegId(registroId);
        c.createData("raton:",mensaje);
        POST2GCM.post(key,c);
        resultado="eviadooooooooo";

        return "mensaje enviado con exito";

    }
}
