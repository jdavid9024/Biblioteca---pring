package com.virtualibrary.Biblioteca.controller;

import com.virtualibrary.Biblioteca.model.Reserva;
import com.virtualibrary.Biblioteca.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaRestController {

    @Autowired
    private ReservaRepository reservaRepository;

    // Crear nueva reserva (desde Postman o frontend)
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Obtener todas las reservas
    @GetMapping
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }
}
