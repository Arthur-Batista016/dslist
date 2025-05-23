package com.arthurbatista.dslist.Controllers;

import com.arthurbatista.dslist.Services.GameService;
import com.arthurbatista.dslist.dto.GameDTO;
import com.arthurbatista.dslist.dto.GameMinDTO;
import com.arthurbatista.dslist.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        return service.findById(id);
    }


}
