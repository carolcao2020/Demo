package lessons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GetDateTime {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
	}
}
