package com.belstu.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@XmlRootElement
public class CommandXml {
    private Long id;
    private String name;
    private Discipline discipline;
    private Set<Player> players;

    public CommandXml() {
    }

    public CommandXml(Command command) {
        this.id = command.getId();
        this.name = command.getName();
        this.discipline = command.getDiscipline();
        this.players = command.getPlayers();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
