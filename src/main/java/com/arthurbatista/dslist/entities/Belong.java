package com.arthurbatista.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belong {

    @EmbeddedId
    private BelongPk id = new BelongPk();

    private Integer position;

    public Belong() {
    }

    public Belong(Game game,GameList list, Integer position) {
        id.setGame(game);
        id.setGamelist(list);
        this.position = position;
    }

    public BelongPk getId() {
        return id;
    }

    public void setId(BelongPk id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
