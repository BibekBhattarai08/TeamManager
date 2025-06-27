package ca.sheridancollege.bibek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ca.sheridancollege.bibek.beans.player;
import java.util.List;
import ca.sheridancollege.datavbase.DatabaseAccess;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlayerController {

    @Autowired
    private DatabaseAccess da;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/player")
    public String showPlayer(Model model) {
        model.addAttribute("player", new player());// this is the player object that is being passed to the player.html
                                                   // page
        return "player";
    }

    @PostMapping("/player")
    public String registerPlayer(@ModelAttribute("player") player player, Model model) {
        da.addPlayer(player);
        List<player> players = da.getPlayers();
        model.addAttribute("players", players);
        return "register";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        List<player> players = da.getPlayers();
        model.addAttribute("players", players);
        return "register";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        player player = da.getPlayerById(id);
        model.addAttribute("player", player);
        return "edit";
    }

    @PostMapping("/update")
    public String updatePlayer(@ModelAttribute("player") player player, Model model) {
        da.updatePlayer(player);
        List<player> players = da.getPlayers();
        model.addAttribute("players", players);
        return "register";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id, Model model) {
        da.deletePlayer(id);
        List<player> players = da.getPlayers();
        model.addAttribute("players", players);
        return "register";
    }
}
