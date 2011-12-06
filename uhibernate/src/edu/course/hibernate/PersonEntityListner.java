package edu.course.hibernate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class PersonEntityListner {
	@PostLoad
	public void readPersonFavoriteNumber(Person person){
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(getFileName(person)));
			String line = bufferedReader.readLine();
			
			person.setFavNumber(Integer.valueOf(line));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bufferedReader!=null){
				try {
					bufferedReader.close();
				} catch (IOException e) {}
			}
		}
		
	}
	@PostPersist
	@PostUpdate
	public void writePersonFavoriteNumber(Person person){
		FileWriter writer=null;
		try {
			File file = new File(getFileName(person));
			file.createNewFile();
			writer = new FileWriter(file);
			writer.write(String.valueOf(person.getFavNumber()));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {}
			}
		}
	}
	private String getFileName(Person person) {
		return person.getId().toString()+".txt";
	}
}
