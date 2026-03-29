package br.com.pratica.paisesapi.controller;

import br.com.pratica.paisesapi.model.Pais;
import br.com.pratica.paisesapi.model.PaisFormulario;
import br.com.pratica.paisesapi.service.PaisService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/")
    public String exibirFormulario(Model model) {
        model.addAttribute("paisFormulario", new PaisFormulario());
        return "index";
    }

    @PostMapping("/buscar")
    public String buscarPais(@Valid @ModelAttribute("paisFormulario") PaisFormulario paisFormulario,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        try {
            Pais pais = paisService.buscarPorNome(paisFormulario.getNomePais());
            model.addAttribute("pais", pais);
            return "resultado";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "index";
        }
    }
}
