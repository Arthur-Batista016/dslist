package com.arthurbatista.dslist.projections;

public interface GameMinProjection {
    // colocar para cada item retornado
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
