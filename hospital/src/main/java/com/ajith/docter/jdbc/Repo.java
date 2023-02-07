package com.ajith.docter.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajith.docter.model.DocterModel;

@Component
public class Repo {
	final String Url = "jdbc:mysql://localhost:3306/kvg";
	final String password = "1996";
	final String username = "root";
	final String table = "docentry";

	@Autowired
	DocterModel doctermodel;

	private Connection connect() throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection(Url, username, password);
		return con;
	}

	private DocterModel get(String quary) {
		
		try {
			Statement statement;
			statement = connect().createStatement();
			ResultSet i = statement.executeQuery(quary);
			while (i.next()) {
				doctermodel.setDid(i.getInt("did"));
				doctermodel.setName(i.getString("name"));
				doctermodel.setAge(i.getInt("age"));
				doctermodel.setGender(i.getString("gender"));
				doctermodel.setPhonenumber(i.getString("Phone_number"));
				doctermodel.setEmailId(i.getString("emailId"));
				doctermodel.setExpirence(i.getInt("expirence"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctermodel;
	}

	private void put(String Query, DocterModel entry) {

		try {
			PreparedStatement statement = connect().prepareStatement(Query);
			statement.setString(1, entry.getName());
			statement.setInt(2, entry.getAge());
			statement.setString(3, entry.getGender());
			statement.setString(4, entry.getEmailId());
			statement.setString(5, entry.getPhonenumber());
			statement.setInt(6, entry.getExpirence());
			int i = statement.executeUpdate();
			System.out.println(i + Query);
		} catch (SQLException e) { 
			e.printStackTrace();
		}

	}

	private void delete(String query) {

		try {
			Statement statement;
			statement = connect().createStatement();
			int i = statement.executeUpdate(query);
			System.out.println(i + query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void save(DocterModel entry) {
		String saveQuery = "insert into " + table + " (did, name, age, gender, emailId, Phone_number, expirence)values "
				+ "(" + entry.getDid()+ ",?,?,?,?,?,?)";
		System.out.println(saveQuery);
//		"insert into "+table+" values("+entry.getDid()+",?)";

		put(saveQuery, entry);
	}

	public void update(int id, DocterModel entry) {
		String updateQuery = "update " + table + " set name = ?, age=?, gender=?, emailId=?, Phone_number=?, expirence=? where  did = " + id;
		System.out.println(updateQuery);
		put(updateQuery, entry);

	}

	public void delete(int id) {
		String deleteQuery = "delete from docentry where did = " + id;
		delete(deleteQuery);
	}

	public void delete() {
		String deleteQuery = "truncate table " + table;
		delete(deleteQuery);
	}

	public DocterModel find(int id) {
		return get("select * from docentry where did = " + id);
	}

	public void findall() {
		get("select * from docentry");
	}

}
