package tju.att.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Holiday entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "holiday", catalog = "qingjia")
public class Holiday implements java.io.Serializable {

	// Fields

	private Long id;
	private String holidayid;
	private String holidayname;
	private String lastday;
	private Integer holidayproperity;
	private Double remainday;

	// Constructors

	/** default constructor */
	public Holiday() {
	}

	/** full constructor */
	public Holiday(String holidayid, String holidayname, String lastday,
			Integer holidayproperity ,Double remainday) {
		this.holidayid = holidayid;
		this.holidayname = holidayname;
		this.lastday = lastday;
		this.holidayproperity = holidayproperity;
		this.remainday = remainday;
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

	@Column(name = "holidayid", nullable = false, length = 50)
	public String getHolidayid() {
		return this.holidayid;
	}

	public void setHolidayid(String holidayid) {
		this.holidayid = holidayid;
	}

	@Column(name = "holidayname", nullable = false, length = 50)
	public String getHolidayname() {
		return this.holidayname;
	}

	public void setHolidayname(String holidayname) {
		this.holidayname = holidayname;
	}

	@Column(name = "lastday", nullable = false, length = 50)
	public String getLastday() {
		return this.lastday;
	}

	public void setLastday(String lastday) {
		this.lastday = lastday;
	}

	@Column(name = "holidayproperity", nullable = false)
	public Integer getHolidayproperity() {
		return this.holidayproperity;
	}

	public void setHolidayproperity(Integer holidayproperity) {
		this.holidayproperity = holidayproperity;
	}
	
	@Column(name = "remainday", nullable = true)
	public Double getRemainday(){
		return this.remainday;
	}
	
	public void setRemainday(Double remainday){
		this.remainday = remainday;
	}

}