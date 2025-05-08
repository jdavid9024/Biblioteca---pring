package com.virtualibrary.Biblioteca.controller;

import com.virtualibrary.Biblioteca.model.Reserva;
import com.virtualibrary.Biblioteca.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reservas")
    public String verReservas(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "5reserva"; // Nombre del archivo HTML en templates
    }
    
    @PostMapping("/reservar")
    public String guardarReserva(
    @RequestParam("usuario")String usuario,
    @RequestParam("sala")String sala,
    @RequestParam("fecha")String fecha,
    @RequestParam("hora")String hora,
    Model model){
    
    Reserva reserva = new Reserva(usuario,sala,fecha,hora);
    reservaRepository.save(reserva);
    model.addAttribute("mensaje", "Reserva guardada exitosamente");
    return "redirect:/reservas"; //redirige para ver la lista actualizada
    }
}
