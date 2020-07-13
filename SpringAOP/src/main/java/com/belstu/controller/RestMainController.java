package com.belstu.controller;

import com.belstu.domain.Command;
import com.belstu.domain.CommandXml;
import com.belstu.exception.NotFountException;
import com.belstu.repositories.CommandRepo;
import com.belstu.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
// for swagger
// http://localhost:8090/swagger-ui.html#/
@RestController
public class RestMainController {

    @Autowired
    private CommandRepo commandRepo;

    @Autowired
    private PlayerRepo playerRepo;


    @GetMapping(value = "/rest")
    public Iterable<Command> list() {
        return commandRepo.findAll();
    }
    // fetch('/rest/2').then(response => response.json().then(console.log))
    @GetMapping(value = "/rest/{id}")
    public Command getOne(@PathVariable Long id) {
        return commandRepo.findById(id).orElseThrow(NotFountException::new);
    }

//fetch(
//  '/rest',
//{
//    method: 'POST',
//            headers: { 'Content-Type': 'application/json' },
//    body: JSON.stringify({ name: 'Team Vitality', discipline: {id: 2, disciplineName: "CS:GO"},players: [] })
//}
//).then(result => result.json().then(console.log))
    @PostMapping(value = "/rest")
    public Iterable<Command> create(
            @RequestBody Command command
    ) {
        commandRepo.save(command);
        return commandRepo.findAll();
    }

    @PutMapping(value = "/rest/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Command updateOne(
            @PathVariable Long id,
            @RequestBody Command newCommand
    ) {

        commandRepo.save(newCommand);
        return commandRepo.findById(id).orElseThrow(NotFountException::new);
    }

    @DeleteMapping(value = "/rest/{id}")
    public void delete(
            @PathVariable Command id
    ) {
        commandRepo.delete(id);
    }

    @GetMapping(value = "/rest/xml/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
    public CommandXml getOneXml(
            @PathVariable Long id
    ) {
        return new CommandXml(commandRepo.findById(id).orElseThrow(NotFountException::new));
    }
}
