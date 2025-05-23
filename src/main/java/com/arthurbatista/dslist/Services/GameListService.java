package com.arthurbatista.dslist.Services;

import com.arthurbatista.dslist.Repositories.GameListRepository;
import com.arthurbatista.dslist.dto.GameDTO;
import com.arthurbatista.dslist.dto.GameListDTO;
import com.arthurbatista.dslist.entities.GameList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> getList(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
}
