package tju.att.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Attendance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "attendance", catalog = "qingjia")
public class Attendance implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userid;
	private Long holidayid;
	private Float lastday;
	private String startday;
	private String endday;
	private String reason;
	private String applyday;
	private String status;

	// Constructors

	/** default constructor */
	public Attendance() {
	}

	/** full constructor */
	public Attendance(Long userid, Long holidayid, Float lastday,
			String startday, String endday, String reason,
			String applyday, String status) {
		this.userid = userid;
		this.holidayid = holidayid;
		this.lastday = lastday;
		this.startday = startday;
		this.endday = endday;
		this.reason = reason;
		this.applyday = applyday;
		this.status = status;
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

	@Column(name = "holidayid", nullable = false)
	public Long getHolidayid() {
		return this.holidayid;
	}

	public void setHolidayid(Long holidayid) {
		this.holidayid = holidayid;
	}

	@Column(name = "lastday", nullable = false, precision = 12, scale = 0)
	public Float getLastday() {
		return this.lastday;
	}

	public void setLastday(Float lastday) {
		this.lastday = lastday;
	}

	
	@Column(name = "startday", nullable = false, length = 0)
	public String getStartday() {
		return this.startday;
	}

	public void setStartday(String startday) {
		this.startday = startday;
	}

	@Column(name = "endday", nullable = false, length = 0)
	public String getEndday() {
		return this.endday;
	}

	public void setEndday(String endday) {
		this.endday = endday;
	}

	@Column(name = "reason", nullable = false)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "applyday", nullable = false, length = 0)
	public String getApplyday() {
		return this.applyday;
	}

	public void setApplyday(String applyday) {
		this.applyday = applyday;
	}

	@Column(name = "status", nullable = false, length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}