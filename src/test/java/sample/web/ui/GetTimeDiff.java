package sample.web.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class GetTimeDiff {
	public static void main(String a[]) {
		Date dat = new Date(0);
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dat);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(df.format(gc.getTime()));
	}
}