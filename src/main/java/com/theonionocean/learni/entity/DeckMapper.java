package com.theonionocean.learni.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DeckMapper implements RowMapper<Deck> {

    @Override
    public Deck mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Deck(rs.getObject("id", UUID.class), rs.getString("name"));
    }
}
