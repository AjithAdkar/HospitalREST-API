package com.ajith.docter.model;

import java.util.HashMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Docter")
public class DocterModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Did;
	@Column(name = "Docter_name")
	private String name;
	@Column(length = 2,name ="Age" )
	private int age;
	@Column(name = "Gender")
	private String gender;
	@Column(name = "EmailId",unique = true)
	private String emailId;
	@Column(name= "Phone_number",unique = true)
	private String phonenumber;
	@Column(name = "Expirence")
	private int expirence;
	@Column(name = "Language")
	private HashMap<Integer, String> language = new HashMap<>();
	@Column(name="Specialization")
	private String specialization;
	@Column(name="Qulification")
	private String Qulification;
	@Column(name = "designation")
	private String designation;
	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
	}
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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