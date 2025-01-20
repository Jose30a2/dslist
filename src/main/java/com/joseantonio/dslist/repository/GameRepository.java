package com.joseantonio.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseantonio.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}
