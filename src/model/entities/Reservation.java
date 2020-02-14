package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		long diferenca = getCheckout().getTime() - getCheckin().getTime();
		return  TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date ucheckin, Date ucheckout) {
		this.checkin = ucheckin;
		this.checkout = ucheckout;
	}
	
	@Override
	public String toString() {
		return "Reservation: "
				+"Room "
				+getRoomNumber()
				+", Check-in: "
				+sdf.format(checkin)
				+", Ckeck-out: "
				+sdf.format(checkout)
				+", Duration: "
				+duration()
				+" nights";
		
	}
}
