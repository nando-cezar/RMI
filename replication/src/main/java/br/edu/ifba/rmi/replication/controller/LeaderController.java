package br.edu.ifba.rmi.replication.controller;

import br.edu.ifba.rmi.replication.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leader")
public class LeaderController {

    private final LeaderService leaderService;

    @Autowired
    public LeaderController(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    @PostMapping("/sendSQL")
    public ResponseEntity<Void> sendSQL(@RequestBody String sql) {
        leaderService.sendSQLCommand(sql);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
