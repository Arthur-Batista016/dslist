package com.arthurbatista.dslist.Services;

import com.arthurbatista.dslist.Repositories.GameRepository;
import com.arthurbatista.dslist.dto.GameDTO;
import com.arthurbatista.dslist.dto.GameMinDTO;
import com.arthurbatista.dslist.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service // ou @Component, dá na mesma
public class GameService {

    @Autowired
    private GameRepository repository;
    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;

    }


}
