package com.ajith.docter.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ajith.docter.jdbc.Repo;
import com.ajith.docter.model.DocterModel;
import com.ajith.docter.repository.Store;
import com.ajith.docter.request.DocRequest;

@Component
public class DocterService {
	@Autowired
	private Store buf;
	@Autowired
	Repo db;

	public Map<Integer, DocterModel> get() {
		db.findall();
		return buf.find();
	}

	public ResponseEntity<Object> get(int id) {
		db.find(id);
		DocterModel record = buf.findid(id);
		if (record == null) {
			return new ResponseEntity<>(db.find(id), HttpStatus.OK);

//			return new ResponseEntity<>("entry not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(db.find(id), HttpStatus.OK);
	}

	public ResponseEntity<Object> put(DocRequest docin) {
		db.save(docin);
		DocterModel response = buf.add(docin);
		if (response == null) {
			return new ResponseEntity<>("duplicate entry", HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	public void empty() {
		db.delete();
		buf.clearDB();
	}

	public void empty(int id) {
		db.delete(id);
		buf.clearDB(id);
	}

	public ResponseEntity<Object> update(DocRequest entry, int id) {
		db.update(id, entry);
		return new ResponseEntity<Object>(buf.update(entry, id) == null ? "notupdated" : entry, HttpStatus.OK);
	}
}
