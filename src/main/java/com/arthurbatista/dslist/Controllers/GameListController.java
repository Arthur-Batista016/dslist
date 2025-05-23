package com.arthurbatista.dslist.Controllers;

import com.arthurbatista.dslist.Services.GameListService;
import com.arthurbatista.dslist.Services.GameService;
import com.arthurbatista.dslist.dto.GameListDTO;
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
    @GetMapping
    public List<GameListDTO> getList(){
        List<GameListDTO> result = service.getList();
        return result;
    }
}
