package com.joseantonio.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.joseantonio.dslist.dto.GameListDTO;

import com.joseantonio.dslist.entities.GameList;
import com.joseantonio.dslist.repository.GameListRepository;


@Service
public class GameListService {
	
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)		//Asegura que la operacion de lectura en la BD sea atomica
	public List<GameListDTO> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		
		
		return result.stream().map(x -> new GameListDTO(x)).toList();
		
	}
	
	
}
