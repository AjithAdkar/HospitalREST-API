package com.ajith.docter.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ajith.docter.model.DocterModel;
import com.ajith.docter.repository.Store;
import com.ajith.docter.request.DocRequest;

@Component
public class DocterService {
	@Autowired
	private Store buf;

	public Map<Integer, DocterModel> get() {
		return buf.find();
	}

	public ResponseEntity<Object> get(int id) {
		DocterModel record = buf.findid(id);
		if (record == null) {
			return new ResponseEntity<>("entry not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(record, HttpStatus.OK);
	}

	public ResponseEntity<Object> put(DocRequest docin) {

		DocterModel response = buf.add(docin);
		if (response == null) {
			return new ResponseEntity<>("duplicate entry", HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	public void empty() {
		buf.clearDB();
	}

	public void empty(int id) {
		buf.clearDB(id);
	}

	public ResponseEntity<Object> update(DocRequest entry, int id) {
		return new ResponseEntity<Object>(buf.update(entry, id) == null ? "notupdated" : entry, HttpStatus.OK);
	}
}
