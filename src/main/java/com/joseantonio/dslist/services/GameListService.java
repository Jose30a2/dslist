package com.joseantonio.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.joseantonio.dslist.dto.GameListDTO;

import com.joseantonio.dslist.entities.GameList;
import com.joseantonio.dslist.projections.GameMinProjection;
import com.joseantonio.dslist.repository.GameListRepository;
import com.joseantonio.dslist.repository.GameRepository;


@Service
public class GameListService {
	
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired 
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)		//Asegura que la operacion de lectura en la BD sea atomica
	public List<GameListDTO> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		
		
		return result.stream().map(x -> new GameListDTO(x)).toList();
		
	}
	
	// Este metodo reposiciona dos objetos de una lista determinada
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i=min; i<=max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
	}
	
	
}
