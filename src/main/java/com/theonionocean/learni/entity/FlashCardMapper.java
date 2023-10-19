package com.theonionocean.learni.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FlashCardMapper implements RowMapper<FlashCard> {

    @Override
    public FlashCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FlashCard(rs.getObject("id", UUID.class), rs.getString("word"), rs.getString("translation"));
    }
}
