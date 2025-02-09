package com.curso.soa.notification.service;

import com.curso.soa.notification.entity.Notificacion;
import com.curso.soa.notification.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public Notificacion notificarCliente(String email, String mensaje) {
        Notificacion notificacion = new Notificacion();
        notificacion.setEmail(email);
        notificacion.setMensaje(mensaje);
        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> getNotifications() {
        return notificacionRepository.findAll();
    }
}