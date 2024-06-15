package Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="paymentid")
	int paymentid;
	
	@ManyToOne
	@JoinColumn(name="smid")
	StudentMaterial sm;
	
	@Column(name="status")
	String status;
	
	@Column(name="paymentDatetime")
	Date paymentDatetime;
	
	
	public Payment() {}


	public Payment(int paymentid, StudentMaterial smid, String status, Date paymentDatetime) {
		super();
		this.paymentid = paymentid;
		this.sm = smid;
		this.status = status;
		this.paymentDatetime = paymentDatetime;
	}


	public int getPaymentid() {
		return paymentid;
	}


	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}


	public StudentMaterial getSm() {
		return sm;
	}


	public void setSmid(StudentMaterial sm) {
		this.sm = sm;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getPaymentDatetime() {
		return paymentDatetime;
	}


	public void setPaymentDatetime(Date paymentDatetime) {
		this.paymentDatetime = paymentDatetime;
	}


	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", sm=" + sm + ", status=" + status + ", paymentDatetime="
				+ paymentDatetime + "]";
	}
	
}
