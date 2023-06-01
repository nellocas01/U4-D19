package com.example.U4D19.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.U4D19.entities.Film;

public class FilmsRowMapper implements RowMapper<Film> {

	@Override
	public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Film fromDb = Film.builder().id(rs.getInt("id")).name(rs.getString("name")).gender(rs.getString("gender"))
				.actor(rs.getString("actor")).build();
		return fromDb;
	}

}
