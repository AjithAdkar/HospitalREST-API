package com.ajith.docter.request;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.ajith.docter.model.DocterModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class DocRequest extends DocterModel{
	@NotNull(message = "enter Docter Id")
	private int Did;
	@NotNull(message = "Enter the name")
	private String name;
	private int age;
	private String gender;
	@Email(message = "Enter Valid Mail ID")
	private String emailId;
	@Pattern(regexp = "^$|[0-9]{10}", message = "invalid formate")
	@Size(max = 10, min = 10, message = "enter valid phone number")
	private String phonenumber;
	private int expirence;
	private HashMap<Integer, String> language = new HashMap<>();
	private String specialization;
	private String Qulification;
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
