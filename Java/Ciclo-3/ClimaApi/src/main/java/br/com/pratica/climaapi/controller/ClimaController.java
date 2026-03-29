package br.com.pratica.climaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.pratica.climaapi.service.ClimaService;

@Controller
public class ClimaController {

 @Autowired
 private ClimaService service;

 @GetMapping("/")
 public String index(){
  return "index";
 }

 @GetMapping("/consultar")
 public String consultar(double latitude,double longitude,Model model){
  model.addAttribute("clima",service.buscar(latitude,longitude));
  return "resultado";
 }
}
