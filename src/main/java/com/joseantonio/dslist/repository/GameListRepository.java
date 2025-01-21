package com.joseantonio.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseantonio.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	
}
