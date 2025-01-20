package com.joseantonio.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joseantonio.dslist.dto.GameMinDTO;
import com.joseantonio.dslist.entities.Game;
import com.joseantonio.dslist.repository.GameRepository;

@Service
public class GameService {
	
	// Inyectar um GameRepository
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		
		// Transformacion, transforma uma lista de games en uma lista de gameMinDTO
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
		
	}
}
