package ca.sheridancollege.bibek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ca.sheridancollege.bibek.beans.player;
import java.util.List;
import java.util.ArrayList;

@Controller
public class PlayerController {
    private List<player> players = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/player")
    public String showPlayer(Model model) {
        model.addAttribute("player", new player());
        return "player";
    }

    @PostMapping("/player")
    public String registerPlayer(@ModelAttribute("player") player player, Model model) {
        players.add(player);
        model.addAttribute("players", players);
        return "register";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("players", players);
        return "register";
    }
}
