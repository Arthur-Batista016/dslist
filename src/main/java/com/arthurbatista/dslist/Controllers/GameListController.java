package com.arthurbatista.dslist.Controllers;

import com.arthurbatista.dslist.Services.GameListService;
import com.arthurbatista.dslist.Services.GameService;
import com.arthurbatista.dslist.dto.GameListDTO;
import com.arthurbatista.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameListDTO> getList(){
        List<GameListDTO> result = service.getList();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
}
