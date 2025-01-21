package com.joseantonio.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseantonio.dslist.dto.GameDTO;
import com.joseantonio.dslist.dto.GameMinDTO;
import com.joseantonio.dslist.entities.Game;
import com.joseantonio.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	// Injetar dependencia services
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		
	/*	List<GameMinDTO> result = gameService.findAll();
		return result;*/
		return gameService.findAll();
		
	}
	
	@GetMapping(value="/{id}")
	public GameDTO findById(@PathVariable Long id){
		
		GameDTO result = gameService.findById(id);
		return result;
		
	}
}
