package com.ajith.docter.respons;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajith.docter.model.DocterModel;

@Component
@ResponseBody
public class DocRespones extends DocterModel {
	private String name;
	private int age;
	private String gender;
	private int expirence;
	private HashMap<Integer, String> language = new HashMap<>();
	private String specialization;
	private String Qulification;
	private String designation;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getExpirence() {
		return expirence;
	}

	public void setExpirence(int expirence) {
		this.expirence = expirence;
	}

	public HashMap<Integer, String> getLanguage() {
		return language;
	}

	public void setLanguage(HashMap<Integer, String> language) {
		this.language = language;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getQulification() {
		return Qulification;
	}

	public void setQulification(String qulification) {
		Qulification = qulification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
