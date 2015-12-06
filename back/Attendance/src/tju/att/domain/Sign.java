package tju.att.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sign entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sign", catalog = "qingjia")
public class Sign implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userid;
	private Timestamp timecome;
	private Timestamp timeleave;

	// Constructors

	/** default constructor */
	public Sign() {
	}

	/** full constructor */
	public Sign(Long userid, Timestamp timecome, Timestamp timeleave) {
		this.userid = userid;
		this.timecome = timecome;
		this.timeleave = timeleave;
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

	@Column(name = "userid", nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "timecome", nullable = false, length = 0)
	public Timestamp getTimecome() {
		return this.timecome;
	}

	public void setTimecome(Timestamp timecome) {
		this.timecome = timecome;
	}

	@Column(name = "timeleave", nullable = false, length = 0)
	public Timestamp getTimeleave() {
		return this.timeleave;
	}

	public void setTimeleave(Timestamp timeleave) {
		this.timeleave = timeleave;
	}

}