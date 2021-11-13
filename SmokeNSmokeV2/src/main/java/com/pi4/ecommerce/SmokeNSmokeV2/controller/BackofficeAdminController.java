package com.pi4.ecommerce.SmokeNSmokeV2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackofficeAdminController {
    
    @GetMapping("/admin")
    public ModelAndView mostrarTela() {
	ModelAndView mv = new ModelAndView("admin");
	return mv;
    }
    
    @PostMapping("/produtos")
    public ModelAndView listaProdutos() {
	ModelAndView mv = new ModelAndView("redirect:/produtos");
        return mv;
    }

}