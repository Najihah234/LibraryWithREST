package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class User {

	@Id
	@Column(name="studentid" )
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int studentid;
	
	@Column(name="matricid" )
	private String matricid;
	
	@Column(name="password" )
	private String password;
	
	@Column(name="fname" )
	private String fname;
	
	@Column(name="lname" )
	private String lname;
	
	@Column(name="email" )
	private String email;
	
	@Column(name="role" )
	private String role;
	
	
	public User() {}
	
	public User(int studentid, String matricid, String password, String fname, String lname, String email,
			String role) {
		super();
		this.studentid = studentid;
		this.matricid = matricid;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getMatricid() {
		return matricid;
	}
	public void setMatricid(String matricid) {
		this.matricid = matricid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [studentid=" + studentid + ", matricid=" + matricid + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", email=" + email + ", role=" + role + "]";
	}
	
}
