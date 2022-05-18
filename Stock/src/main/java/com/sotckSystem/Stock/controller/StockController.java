package com.sotckSystem.Stock.controller;

import com.sotckSystem.Stock.model.DTO.Login;
import com.sotckSystem.Stock.model.DTO.StockDTO;

import com.sotckSystem.Stock.model.Usuario;
import com.sotckSystem.Stock.service.StockService;
import com.sotckSystem.Stock.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StockService service;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/logar")
    public String logar(Model model, @ModelAttribute("login") Login login){
        Usuario user = usuarioService.findByCpf(login.getUser());
        if(user.getSenha().equals(login.getPassword())){
            if (user.getTipo() == 1){
                return "redirect:/admPage";
            }
            String retorno = "redirect:/logado?cpf="+user.getCpf();
            return retorno;
        }
        return "index";
    }
    @GetMapping(value = "/logado")
    public String home(Model model, @ModelAttribute("cpf") String cpf){
        StockDTO stockBusca = new StockDTO();
        model.addAttribute("stockBusca", stockBusca);
        model.addAttribute("stocks", service.findByDono(cpf));
        model.addAttribute("soma", service.somaInvestido(cpf));
        model.addAttribute("user", usuarioService.findByCpf(cpf));
        return "index";
    }
    @GetMapping(value = "/filterToday")
    public String filterToday(Model model){
        List<StockDTO> dtos = service.findByToday();
        StockDTO stockBusca = new StockDTO();
        model.addAttribute("stockBusca",stockBusca);
        model.addAttribute("stocks", dtos);
        return "index";
    }
    @GetMapping(value = "/showAddPage")
    public String showAddPage(Model model, @ModelAttribute("user") Usuario user){
        StockDTO dto = new StockDTO();
        model.addAttribute("stockdto", dto);
        model.addAttribute("user", user);
        return "pageAdd";
    }
    @GetMapping(value = "/showFormForUpdate/{id}")
    public String updateStock(@PathVariable("id") Long id, Model model){
        StockDTO dto = service.findById(id);
        model.addAttribute("stockForUp", dto);
        return "pageUp";
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@ModelAttribute("id") Long id, Model model){
        service.delete(id);
        return "redirect:/";
    }
    @PostMapping(value = "/filterName")
    public String filterName(@ModelAttribute("stockBusca") StockDTO stockBusca, Model model){
        StockDTO busca = new StockDTO();
        model.addAttribute("stockBusca",busca);
        List<StockDTO> dtos = service.findByName(stockBusca.getName());
        model.addAttribute("stocks", dtos);
        return "index";
    }
    @PostMapping(value = "/saveStock")
    public String saveStock(@Valid @ModelAttribute("stockdto")  StockDTO dto, Model model){
        String retorno = "redirect:/logado?cpf="+dto.getDono();
        service.save(dto);
        return retorno;
    }
    @PostMapping(value = "/updateStock")
    public String updateStock(@ModelAttribute("stockForUp") @Valid StockDTO stockUp, Model model){
        service.update(stockUp);
        return "redirect:/";
    }
    @GetMapping(value = "/")
    public String fazerLogin(Model model){
        Login login = new Login();
        model.addAttribute("login", login);
        return "loginAdm";
    }
    @GetMapping(value = "/admPage")
    public String login(Model model, @ModelAttribute("login") Login login){
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);
        return "paginaADM";
    }
    @GetMapping(value = "/gerarCsv/{id}")
    public String gerarCsv(@PathVariable String id){
        String retorno = "redirect:/logado?cpf="+id;
        service.gerarCsv(id);
        return retorno;
    }
    @GetMapping(value="/showTelaCadastro")
    public String telaCadastro(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "telaCadastro";
    }
    @PostMapping(value = "/saveUsuario")
    public String saveUser(@ModelAttribute Usuario usuario, Model model ){
        usuarioService.save(usuario);
        return "redirect:/";
    }
}
