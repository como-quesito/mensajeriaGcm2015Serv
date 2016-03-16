package org.campitos;

/**
 * Created by campitos on 5/26/15.
 */
public class RegistroMensajeria {
    String registroId;

    public RegistroMensajeria() {
    }

    public RegistroMensajeria(String registroId) {
        this.registroId = registroId;
    }

    public String getRegistroId() {
        return registroId;
    }

    public void setRegistroId(String registroId) {
        this.registroId = registroId;
    }
}
