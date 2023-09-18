package com.trello.gmc.genericutility;

import java.time.LocalDateTime;
/**
 * @author CodeRoverAbhay
 */
public class JavaUtility {
	/**
	 * timeStamp method is used to capture the real date and time
	 * @return Local date and time
	 */
	public String timeStamp() {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
	}
}