package ca.bcit.comp3656.assign.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattedTime {
	
	private String timeFormatted;
	DateTimeFormatter dtf   = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public FormattedTime() {
		
	}

	public FormattedTime(LocalDateTime time) {
		super();
		this.timeFormatted = dtf.format(time);
		System.out.println("|---------------------->" + this.getClass().getName() + " " + timeFormatted);

	}

	public String getTimeFormatted() {
		return this.timeFormatted;
	}

	public void setTimeFormatted(LocalDateTime time) {
		this.timeFormatted = dtf.format(time);

	}
	

}
