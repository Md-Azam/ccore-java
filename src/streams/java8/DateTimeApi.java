package streams.java8;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.*;
public class DateTimeApi {
	public static void main(String[] args) {
		
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.parse("24-08-1999",DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Period age = Period.between(d1, d2);
		System.out.println(age.getYears());
		System.out.println(age.getMonths());
		System.out.println(age.getDays());
		System.out.println(age.getChronology());
		System.out.println(age.negated());
	}

}
