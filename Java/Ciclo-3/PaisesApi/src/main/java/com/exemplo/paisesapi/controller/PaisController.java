package com.exemplo.paisesapi.controller;

import com.exemplo.paisesapi.model.Pais;
import com.exemplo.paisesapi.service.PaisService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("/paises")
@Validated
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public String exibirFormulario(Model model) {
        model.addAttribute("consultaPais", new ConsultaPais());
        return "formulario-pais";
    }

    @PostMapping
    public String buscarPais(@ModelAttribute("consultaPais") @Validated ConsultaPais consultaPais,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "formulario-pais";
        }

        try {
            Pais pais = paisService.buscarPorNome(consultaPais.getNome());
            model.addAttribute("pais", pais);
            return "resultado-pais";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("erro", ex.getMessage());
            return "formulario-pais";
        }
    }

    public static class ConsultaPais {
        @NotBlank(message = "Digite o nome de um país em inglês.")
        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
