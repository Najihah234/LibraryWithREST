package Model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "slot")
public class Slot {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "slotid")
	int slotid;
	
	@Column(name="slot")
	Time slot;
	
	public Slot() {}

	public Slot(int slotid, Time slot) {
		super();
		this.slotid = slotid;
		this.slot = slot;
	}

	public int getSlotid() {
		return slotid;
	}

	public void setSlotid(int slotid) {
		this.slotid = slotid;
	}

	public Time getSlot() {
		return slot;
	}

	public void setSlot(Time slot) {
		this.slot = slot;
	}

	@Override
	public String toString() {
		return "Slot [slotid=" + slotid + ", slot=" + slot + "]";
	}
	
	
}
