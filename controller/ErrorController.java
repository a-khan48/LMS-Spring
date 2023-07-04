package com.example.library.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        model.addAttribute("errorMessage", "Eror 4o4!");
        return "error";
    }
}
