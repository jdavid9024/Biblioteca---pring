package com.virtualibrary.Biblioteca.controller;

import com.virtualibrary.Biblioteca.model.User;
import com.virtualibrary.Biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Muestra todos los usuarios
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";  // El nombre del archivo HTML donde se mostrarán los usuarios
    }

    // Muestra el formulario para agregar un nuevo usuario
    @GetMapping("/users/new")
    public String showUserForm() {
        return "userForm";  // El nombre del archivo HTML con el formulario
    }

    // Guarda un nuevo usuario
    @PostMapping("/users/save")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/users";  // Redirige a la lista de usuarios después de guardar
    }
}
