package org.java.com.model;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_tbl_bak", catalog = "room")
public class UserTbl implements Serializable {

	private static final long serialVersionUID = 2914160291772344637L;
	private int id;
	private int easyId;
	private String username;
	private String fullname;
	private String timeStamp;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", length = 20)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "easy_id", length = 10)
	public int getEasyId() {
		return easyId;
	}

	public void setEasyId(int easyId) {
		this.easyId = easyId;
	}

	@Column(name = "username", length = 32)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "fullname", length = 127)
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "time_stamp")
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
