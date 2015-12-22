package tju.att.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "qingjia")
public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String phone;
	private String department;
	private String pwd;
	private String name;
	private Integer gender;
	private Date birthday;
	private String position;
	private String email;
	private Date startworkdate;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String phone, String pwd, String name, Integer gender,
			Date birthday, String position, String email, Date startworkdate) {
		this.phone = phone;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.position = position;
		this.email = email;
		this.startworkdate = startworkdate;
	}

	/** full constructor */
	public User(String phone, String department, String pwd, String name,
			Integer gender, Date birthday, String position, String email, Date startworkdate) {
		this.phone = phone;
		this.department = department;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.position = position;
		this.email = email;
		this.startworkdate = startworkdate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "phone", nullable = false, length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "department", length = 50)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "pwd", nullable = false, length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender", nullable = false)
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", nullable = false, length = 0)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "position", nullable = false, length = 50)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "startworkdate", nullable = true, length = 0)
	public Date getStartworkdate() {
		return this.startworkdate;
	}

	public void setStartworkdate(Date startworkdate) {
		this.startworkdate = startworkdate;
	}
	
	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}