package org.campitos;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by campitos on 5/26/15.
 */

@Repository
public class ServicioRegistro {
    @Inject
    MongoTemplate mongoTemplate;

    public void agregarRegistro(RegistroMensajeria registro){
        if(!mongoTemplate.collectionExists(RegistroMensajeria.class)){
            mongoTemplate.createCollection(RegistroMensajeria.class);
        }
        mongoTemplate.insert(registro);
    }

    public List<RegistroMensajeria> getTodos(){
        List<RegistroMensajeria> registros=new ArrayList<RegistroMensajeria>();
        registros=mongoTemplate.findAll(RegistroMensajeria.class);
        return registros;
    }
}
