package com.example.U4D19.dao;

import java.util.List;

import com.example.U4D19.entities.Film;

public interface FilmDAO {

	public List<Film> findAll();

	public Film findById(int id);

	public void save(Film film);

	public int findByIdAndUpdate(int id, Film film);

	public int findByIdAndDelete(int id);

	public int count();
}
