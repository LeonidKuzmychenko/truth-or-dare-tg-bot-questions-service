package com.ltechlab.truthordare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ltechlab.truthordare.dto.CheckSessionDto;
import com.ltechlab.truthordare.dto.QuestionResponseDto;
import com.ltechlab.truthordare.dto.SessionDto;
import com.ltechlab.truthordare.service.QuestionService;

@RestController
@RequestMapping("/game")
@AllArgsConstructor
public class GameController {

    private final QuestionService service;

    @GetMapping("/session")
    public ResponseEntity<CheckSessionDto> checkSession(@RequestParam("session") String session) {
        Boolean isExist = service.gameIsExist(session);
        return new ResponseEntity<>(new CheckSessionDto(isExist), HttpStatus.OK);
    }

    @GetMapping("/question")
    public ResponseEntity<QuestionResponseDto> nextQuestion(@RequestParam("session") String session) {
        return service.nextLevelUpQuestion(session)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/start")
    public ResponseEntity<SessionDto> initNewGame(@RequestParam("male") String male,
                                                  @RequestParam("female") String female) {
        String session = service.start(male, female);
        return new ResponseEntity<>(new SessionDto(session), HttpStatus.OK);
    }
}