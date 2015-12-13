package tju.att.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Check entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "check", catalog = "qingjia")
public class Check implements java.io.Serializable {

	// Fields

	private Long id;
	private Long attendanceid;
	private Long userid;
	private String reason;
	private Integer checkresult;
	private String property;

	// Constructors

	/** default constructor */
	public Check() {
	}

	/** minimal constructor */
	public Check(Long attendanceid, Long userid, Integer checkresult,
			String property) {
		this.attendanceid = attendanceid;
		this.userid = userid;
		this.checkresult = checkresult;
		this.property = property;
	}

	/** full constructor */
	public Check(Long attendanceid, Long userid, String reason,
			Integer checkresult, String property) {
		this.attendanceid = attendanceid;
		this.userid = userid;
		this.reason = reason;
		this.checkresult = checkresult;
		this.property = property;
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

	@Column(name = "attendanceid", nullable = false)
	public Long getAttendanceid() {
		return this.attendanceid;
	}

	public void setAttendanceid(Long attendanceid) {
		this.attendanceid = attendanceid;
	}

	@Column(name = "userid", nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "reason", length = 500)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "checkresult", nullable = false)
	public Integer getCheckresult() {
		return this.checkresult;
	}

	public void setCheckresult(Integer checkresult) {
		this.checkresult = checkresult;
	}

	@Column(name = "property", nullable = false, length = 50)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

}