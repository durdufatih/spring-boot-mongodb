package com.fatihdurdu.player;

import com.fatihdurdu.player.model.PlayerDto;
import com.fatihdurdu.player.model.PlayerRequest;
import com.fatihdurdu.player.model.PlayerResponse;
import com.fatihdurdu.player.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    private List<PlayerResponse> getAll() {
        List<PlayerDto> dtoList = playerService.list();
        return dtoList.stream().map(item ->convertResponse(item)).toList();
    }

    @PostMapping
    private PlayerResponse save(@RequestBody PlayerRequest playerRequest){
        PlayerDto savedObject = playerService.createPlayer(createDtoFromRequest(playerRequest));
        return convertResponse(savedObject);
    }


    private PlayerResponse convertResponse(PlayerDto dto) {
        return new PlayerResponse(dto.getId(), dto.getName(), dto.getNationality(), dto.getBirthDate(), dto.getPosition());
    }

    private PlayerDto createDtoFromRequest(PlayerRequest playerRequest){
        return new PlayerDto(playerRequest.getName(),playerRequest.getNationality(),playerRequest.getBirthDate(),playerRequest.getPosition());
    }
}
