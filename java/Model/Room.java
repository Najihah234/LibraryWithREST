package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@Column(name="roomid")
	@GeneratedValue(strategy= GenerationType.AUTO)
	int roomid;
	
	@Column(name="roomname")
	String roomname;
	
	public Room() {}
	
	public Room(int roomid, String roomname) {
		super();
		this.roomid = roomid;
		this.roomname = roomname;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomname=" + roomname + "]";
	}
	
	
	

}
