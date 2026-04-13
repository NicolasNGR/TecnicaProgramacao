package com.example.cadastroprodutos.controller;

import com.example.cadastroprodutos.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ProdutoController {

    private static final List<Produto> produtos = new ArrayList<>();
    private static final AtomicLong contador = new AtomicLong(1);

    @GetMapping("/")
    public String inicio() {
        return "redirect:/form";
    }

    @GetMapping("/form")
    public String exibirFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto, Model model) {
        if (produto.getPreco() < 0) {
            model.addAttribute("erro", "O preço não pode ser menor que zero.");
            model.addAttribute("produto", produto);
            return "form";
        }

        produto.setId(contador.getAndIncrement());
        produtos.add(produto);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("produtos", produtos);
        model.addAttribute("totalProdutos", produtos.size());
        return "lista";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
        return "redirect:/lista";
    }
}
