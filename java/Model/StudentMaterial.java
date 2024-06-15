package Model;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studentmaterial")
public class StudentMaterial {
	
	@Id
	@Column(name="smid")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int smid;
	
	@ManyToOne
	@JoinColumn(name="studentid")
	User student;
	
	@ManyToOne
	@JoinColumn(name="materialid")
	Material material;
	
	@Column(name="requestDatetime")
	Date requestDatetime;
	
	@Column(name="status")
	String status;
	
	@Column(name="approvedDatetime" )
	@Basic(optional=true)
	Date approvedDatetime;
	
	
	@Column(name="returnDatetime")
	@Basic(optional=true)
	Date returnDatetime;
	
	public StudentMaterial() {}
	
	public StudentMaterial(int smid, User student, Material material, Date date, String status,
			Date temp,  Date temp3) {
		super();
		this.smid = smid;
		this.student = student;
		this.material = material;
		this.requestDatetime = date;
		this.status = status;
		this.approvedDatetime = temp;
		this.returnDatetime = temp3;
	}



	public int getSmid() {
		return smid;
	}

	public void setSmid(int smid) {
		this.smid = smid;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Date getRequestDatetime() {
		return requestDatetime;
	}

	public void setRequestDatetime(Date requestDatetime) {
		this.requestDatetime = requestDatetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApprovedDatetime() {
		return approvedDatetime;
	}

	public void setApprovedDatetime(Date approvedDatetime) {
		this.approvedDatetime = approvedDatetime;
	}

	
	public Date getReturnDatetime() {
		return returnDatetime;
	}

	public void setReturnDatetime(Date returnDatetime) {
		this.returnDatetime = returnDatetime;
	}

	@Override
	public String toString() {
		return "StudentMaterial [smid=" + smid + ", student=" + student + ", material=" + material
				+ ", requestDatetime=" + requestDatetime + ", status=" + status + ", approvedDatetime="
				+ approvedDatetime + ", returnDatetime=" + returnDatetime + "]";
	}
	

}
