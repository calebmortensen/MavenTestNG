import java.util.Date;

public class DateTest {

	
	public static void main(String[] args) {
		generateEmailTimeStamp();
	}
	public static String generateEmailTimeStamp() {

		Date date = new Date();
		System.out.println(date);
		System.out.println(date.toString().replace(" ", "_").replace(":", " ") + "@gmail.com"); 
		return date.toString().replace(" ", "_").replace(":", " ") + "@gmail.com";
	}

}
