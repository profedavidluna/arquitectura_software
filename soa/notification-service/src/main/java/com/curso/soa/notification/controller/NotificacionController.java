package com.curso.soa.notification.controller;
import com.curso.soa.notification.entity.Notificacion;
import com.curso.soa.notification.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificacionController {

    @Autowired
    private NotificacionService notificationService;

    @PostMapping
    public Notificacion notificarCliente(@RequestParam String email, @RequestParam String mensaje) {
        return notificationService.notificarCliente(email, mensaje);
    }
}