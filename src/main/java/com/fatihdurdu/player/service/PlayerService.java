package com.fatihdurdu.player.service;

import com.fatihdurdu.player.model.Player;
import com.fatihdurdu.player.model.PlayerDto;
import com.fatihdurdu.player.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerDto createPlayer(PlayerDto dto) {
        Player activePlayer = convertToEntity(dto);
        PlayerDto resultObject = convertToDto(playerRepository.save(activePlayer));
        return resultObject;

    }

    public List<PlayerDto> list() {
        return playerRepository.findAll().stream().map(item -> convertToDto(item)).toList();
    }

    private Player convertToEntity(PlayerDto dto) {
        Player player = new Player();
        player.setBirthDate(dto.getBirthDate());
        player.setNationality(dto.getNationality());
        player.setPosition(dto.getPosition());
        player.setName(dto.getName());
        return player;
    }

    private PlayerDto convertToDto(Player player) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setBirthDate(player.getBirthDate());
        playerDto.setNationality(player.getNationality());
        playerDto.setPosition(player.getPosition());
        playerDto.setName(player.getName());
        return playerDto;
    }
}
