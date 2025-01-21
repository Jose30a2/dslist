package com.joseantonio.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseantonio.dslist.dto.GameDTO;
import com.joseantonio.dslist.dto.GameMinDTO;
import com.joseantonio.dslist.entities.Game;
import com.joseantonio.dslist.repository.GameRepository;

@Service
public class GameService {
	
	// Inyectar um GameRepository
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)		//Asegura que la operacion de lectura en la BD sea atomica
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		
		// Transformacion, transforma uma lista de games en uma lista de gameMinDTO
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}
	
	// Buscar por id
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		
		// TODO tratamento de excepciones en caso de que el id no existiese
		
		return new GameDTO(result);
		
	}
}
