package com.icss.biz;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.dao.MovieDao;
import com.icss.entity.Movie;
import com.icss.kafka.KafkaProduce;
@Service
public class MovieBiz {
@Autowired 
MovieDao movieDao;
@Autowired
KafkaProduce kafkaProduce;
	public List<Movie> queryMovie() throws Exception {		
		return movieDao.queryMovie();
	}
	
	public void deleteMovie(String code) throws Exception {
		movieDao.deleteMovie(code);
		File file=new File("D://img//");
		File[] fs=file.listFiles();
		for(File f:fs) {
			if(f.getName().split("\\.")[0].equals(code)) {
				f.delete();
				break;
			}
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				kafkaProduce.sendMessage("movie", code, "deleteMovie");
			}
		}).start();			
	}
	public void addMovie(Movie movie) throws Exception {
		movieDao.addMovie(movie);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				kafkaProduce.sendMessage("movie", movie.getCode()+"", "addMovie");
			}
		}).start();			
	}

	public void editMovie(Movie movie) throws Exception {
		movieDao.editMovie(movie);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				kafkaProduce.sendMessage("movie", movie.getCode()+"", "editMovie");
			}
		}).start();	
	}

}
