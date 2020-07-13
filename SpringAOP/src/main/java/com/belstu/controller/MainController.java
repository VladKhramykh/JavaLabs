package com.belstu.controller;

import com.belstu.domain.Command;
import com.belstu.domain.Discipline;
import com.belstu.domain.Player;
import com.belstu.repositories.CommandRepo;
import com.belstu.repositories.DisciplineRepo;
import com.belstu.repositories.PlayerRepo;
import com.belstu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private DisciplineRepo disciplineRepo;
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private CommandRepo commandRepo;

    @GetMapping("/")
    public String greeting(
            Model model
    ){
        model.addAttribute("name", "World");
        return "greeting";
    }

    @GetMapping("/main")
    public String showCommands(
            @AuthenticationPrincipal Player player,
            Model model
    ){
        model.addAttribute("players", player.getCommand().getPlayers());
        return "main";
    }


    @GetMapping("/reg")
    public String showReg(
            Model model
    ){
        model.addAttribute("disciplines", disciplineRepo.findAll());
        return "reg";
    }

    @PostMapping("/registration")
    public String registration(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam Command command,
            Model model
    ){
        Player player = new Player(firstName, lastName, password, username);
        player.setCommand(command);
        userService.registration(player);

        return "/login";
    }

    @GetMapping("/registration")
    public String playerReg(
            @RequestParam Discipline discipline,
            Model model
    ){
        model.addAttribute("commands", commandRepo.findAllByDiscipline(discipline));
        return "registration";
    }
}
