package com.example.U4D19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.U4D19.dao.FilmDAOImpl;
import com.example.U4D19.entities.Film;

@Component
public class FilmsRunner implements CommandLineRunner {
	@Autowired
	FilmDAOImpl fDao;

	@Override
	public void run(String... args) throws Exception {
		Film f1 = Film.builder().name("fast&furious4").gender("history").actor("piero angela").build();

		System.out.println("*********FILM AGGIUNTO******");
		fDao.save(f1);

		System.out.println("********* TROVALI TUTTI*******");
		fDao.findAll().forEach(film -> System.out.println(film));

		System.out.println("************TROVA PER ID*******");
		System.out.println(fDao.findById(4));

		System.out.println("**********TROVA PER ID E CAMBIALO********");
		Film f2 = Film.builder().name("fast&furious5").gender("science").actor("jason sthatman").build();

		int updateRows = fDao.findByIdAndUpdate(1, f2);
		if (updateRows == 0) {
			System.out.println("film non trovato");
		} else {
			System.out.println(fDao.findById(1));
		}

		System.out.println("***********TROVA PER ID E ELIMINA******");
		int deleteRows = fDao.findByIdAndDelete(2);
		if (deleteRows == 0) {
			System.out.println("film non trovato");
		} else {
			fDao.findAll().forEach(film -> System.out.println(film));
		}

		System.out.println("*********COUNT******");
		System.out.println("numero film in db: " + fDao.count());
	}

}
