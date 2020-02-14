package applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Reservation res=null;
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.print("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out: ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva; Datas inválidas.");
		}
		else {	
			res = new Reservation(roomNumber, checkin, checkout);
			System.out.println(res);
		}
		
		System.out.println("Update de reserva");
		System.out.print("Check-in: ");
		Date ucheckin = sdf.parse(sc.next());
		System.out.print("Check-out: ");
		Date ucheckout = sdf.parse(sc.next());
		
		Date now = new Date();
		if(ucheckin.before(now) || ucheckout.before(now)) {
			System.out.println("Erro! A reserva deve ter datas futuras.");
		}
		else if(!ucheckout.after(ucheckin)) {
			System.out.println("A  data de check-out deve ser maior que a data de check-in.");
		}else {
			res.updateDates(ucheckin, ucheckout);
			System.out.println(res);
		}
		
		
		sc.close();

	}

}
