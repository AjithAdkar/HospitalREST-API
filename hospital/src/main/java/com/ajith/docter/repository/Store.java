package com.ajith.docter.repository;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.ajith.docter.model.DocterModel;
import com.ajith.docter.request.DocRequest;

@Component

public class Store {
	private HashMap<Integer, DocterModel> db = new HashMap<>();

	public final DocterModel add(DocterModel entry) {
		if (db.containsKey(entry.getDid())) {
			return null;
		} else
			db.put(entry.getDid(), entry);
		return db.get(entry.getDid());
	}

	public final DocterModel findid(int id) {
		if (db.isEmpty()) {
			return null;
		}
		return db.get(id);
	}

	public final HashMap<Integer, DocterModel> find() {
		if (db.isEmpty()) {
			return null;
		}
		return db;

	}

	public void clearDB() {
		db.clear();
	}

	public void clearDB(int id) {

		db.remove(id);
	}

	public DocterModel update(DocRequest entry, int id) {
		if (db.containsKey(id)) {
			DocterModel buf = db.get(id);
			if (entry.getAge() != buf.getAge())
				buf.setAge(entry.getAge());
			if (entry.getGender() != buf.getGender())
				buf.setGender(entry.getGender());
			if (entry.getEmailId() != buf.getEmailId())
				buf.setEmailId(entry.getEmailId());
			if (entry.getExpirence() != buf.getExpirence())
				buf.setExpirence(entry.getExpirence());
			if (entry.getName() != buf.getName())
				buf.setName(entry.getName());
			if (entry.getSpecialization() != buf.getSpecialization())
				buf.setSpecialization(entry.getSpecialization());
			if (entry.getPhonenumber() != buf.getPhonenumber())
				buf.setPhonenumber(entry.getPhonenumber());
			if (entry.getQulification() != buf.getQulification())
				buf.setQulification(entry.getQulification());
			if (entry.getLanguage() != buf.getLanguage())
				buf.setLanguage(entry.getLanguage());
			if (entry.getDesignation() != buf.getDesignation())
				buf.setDesignation(entry.getDesignation());
			
			db.put(id, buf);
			return db.get(id);
		}

		return null;
	}
}