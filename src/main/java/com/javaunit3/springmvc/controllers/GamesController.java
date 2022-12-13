package com.javaunit3.springmvc.controllers;

import com.javaunit3.springmvc.model.SwitchGame;
import com.javaunit3.springmvc.services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/games")
public class GamesController {
    private GamesService service;

    @Autowired
    public GamesController(GamesService service) {
        this.service = service;
    }

    @RequestMapping("")
    public String listGames(Model model) {
        var games = this.service.listGames();
        model.addAttribute("games", games);

        return "games";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewGame() {
        return "games-add";
    }

    @RequestMapping(value = "/addHandler", method = RequestMethod.POST)
    public String handleAddNewGame(HttpServletRequest request) {
        var title = request.getParameter("title");
        var publisher = request.getParameter("publisher");
        var rating = request.getParameter("rating");

        var game = new SwitchGame(title, publisher, rating);
        this.service.addGame(game);

        return "redirect:/games";
    }
}
