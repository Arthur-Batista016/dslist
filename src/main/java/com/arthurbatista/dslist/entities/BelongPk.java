package com.arthurbatista.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable //define que a classe representa dois campos
public class BelongPk {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gamelist;


    public BelongPk() {
    }

    public BelongPk(Game game, GameList gamelist) {
        this.game = game;
        this.gamelist = gamelist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongPk belongPk)) return false;
        return Objects.equals(game, belongPk.game) && Objects.equals(gamelist, belongPk.gamelist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gamelist);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGamelist() {
        return gamelist;
    }

    public void setGamelist(GameList gamelist) {
        this.gamelist = gamelist;
    }
}
