package com.arthurbatista.dslist.Services;

import com.arthurbatista.dslist.Repositories.GameListRepository;
import com.arthurbatista.dslist.Repositories.GameRepository;
import com.arthurbatista.dslist.dto.GameDTO;
import com.arthurbatista.dslist.dto.GameListDTO;
import com.arthurbatista.dslist.entities.GameList;
import com.arthurbatista.dslist.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.transform.Source;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> getList(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;


        for(int i = min;i<=max;i++ ){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }
}
