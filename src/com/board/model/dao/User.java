package com.board.model.dao;
// Generated 2020. 3. 26 ���� 1:30:31 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "boarddb")
@NamedQueries({
	@NamedQuery(name = "user.login", query = User.GET_LOGIN)
})
public class User implements java.io.Serializable {
	
	static final String GET_LOGIN = "select u from User u where email = :email";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String fullname;
	private String gender;
	private String password;
	private String role;

	public User() {
	}

	public User(String email, String fullname, String gender, String password, String role) {
		this.email = email;
		this.fullname = fullname;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "EMAIL", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "FULLNAME", nullable = false, length = 45)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "GENDER", nullable = false, length = 8)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "PASSWORD", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "ROLE", length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
