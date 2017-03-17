package ua.bakery.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class ProgramSettings {

	private ProgramSettings() { }
	
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
}
