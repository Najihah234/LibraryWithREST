package Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentroom")
public class StudentRoom {
	
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		@Column(name = "srid")
		int srid;
		
		@ManyToOne
		@JoinColumn(name = "roomid")
		Room room;
		
		@ManyToOne
		@JoinColumn(name = "studentid")
		User student;
		
		@ManyToOne
		@JoinColumn(name = "slotid")
		//@Column(name="slotid")
		Slot slotid;
		
		@Column(name = "bookingDate")
		Date bookingDate;
		
		@Column(name = "applicationDate")
		Date applicationDate;
		
		@Column(name = "applicationStatus")
		String applicationStatus;
		
		@Column(name = "availability")
		String availability;
		
		public StudentRoom () {}
		
		public StudentRoom(int srid, Room room, User student, Slot slotid, Date bookingDate, Date applicationDate,
				String applicationStatus, String availability) {
			super();
			this.srid = srid;
			this.room = room;
			this.student = student;
			this.slotid = slotid;
			this.bookingDate = bookingDate;
			this.applicationDate = applicationDate;
			this.applicationStatus = applicationStatus;
			this.availability = availability;
		}

		public int getSrid() {
			return srid;
		}

		public void setSrid(int srid) {
			this.srid = srid;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public User getStudent() {
			return student;
		}

		public void setStudent(User student) {
			this.student = student;
		}

		public Slot getSlotid() {
			return slotid;
		}

		public void setSlotid(Slot slotid) {
			this.slotid = slotid;
		}

		public Date getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}

		public Date getApplicationDate() {
			return applicationDate;
		}

		public void setApplicationDate(Date applicationDate) {
			this.applicationDate = applicationDate;
		}

		public String getApplicationStatus() {
			return applicationStatus;
		}

		public void setApplicationStatus(String applicationStatus) {
			this.applicationStatus = applicationStatus;
		}

		public String getAvailability() {
			return availability;
		}

		public void setAvailability(String availability) {
			this.availability = availability;
		}

		@Override
		public String toString() {
			return "StudentRoom [srid=" + srid + ", room=" + room + ", student=" + student + ", slotid=" + slotid
					+ ", bookingDate=" + bookingDate + ", applicationDate=" + applicationDate + ", applicationStatus="
					+ applicationStatus + ", availability=" + availability + "]";
		}
		
		

}
