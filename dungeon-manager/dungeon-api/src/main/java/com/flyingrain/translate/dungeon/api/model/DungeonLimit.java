package com.flyingrain.translate.dungeon.api.model;

import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

public class DungeonLimit {

    @NotBlank
    private String limitName;

    private String type;

    private String value;


}
