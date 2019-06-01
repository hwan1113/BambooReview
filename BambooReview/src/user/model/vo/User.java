package user.model.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements Serializable, HttpSessionBindingListener{
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private String userName;
	private String phone;
	private String profile;
	private Date enrollDate;
	private Date quitDate;
	private String status;
	private int customer_no;

	public User(String email, String password, String userName, String phone, String profile, Date enrollDate,
			Date quitDate, String status, int customer_no) {
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.phone = phone;
		this.profile = profile;
		this.enrollDate = enrollDate;
		this.quitDate = quitDate;
		this.status = status;
		this.customer_no = customer_no;
	}
	
	public User() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getQuitDate() {
		return quitDate;
	}
	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", userName=" + userName + ", phone=" + phone
				+ ", profile=" + profile + ", enrollDate=" + enrollDate + ", quitDate=" + quitDate + ", status="
				+ status + ", customer_no=" + customer_no + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
