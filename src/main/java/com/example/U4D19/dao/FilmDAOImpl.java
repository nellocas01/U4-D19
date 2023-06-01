package com.example.U4D19.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.U4D19.entities.Film;

@Repository
public class FilmDAOImpl implements FilmDAO {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<Film> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM film";
		return jdbc.query(sql, new FilmsRowMapper());
	}

	@Override
	public Film findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM film WHERE id = ?";
		return jdbc.queryForObject(sql, new FilmsRowMapper(), id);
	}

	@Override
	public void save(Film film) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO film (name, gender, actor) VALUES (?, ?, ?)";
		jdbc.update(sql, film.getName(), film.getGender(), film.getActor());
	}

	@Override
	public int findByIdAndUpdate(int id, Film film) {
		// TODO Auto-generated method stub
		String sql = "UPDATE film SET name=?, gender=?, actor=? WHERE id=?";

		return jdbc.update(sql, film.getName(), film.getGender(), film.getActor(), id);
	}

	@Override
	public int findByIdAndDelete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM film WHERE id=?";
		return jdbc.update(sql, id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM film";
		return jdbc.queryForObject(sql, Integer.class);
	}

}
