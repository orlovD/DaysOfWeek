public class DaysOfWeek {
	
	public static String integerToDays(Integer days) {
		boolean daysArr[] = {false, false, false, false, false, false, false};
		StringBuilder daysStr = new StringBuilder();
		
		//range of provided weekdays
		int start = 6;
		int finish = 0;
		
		//convert given Integer into boolean array of weekdays
		int d = days;
		while (d > 0) {
			int day = d % 10;
			daysArr[day - 1] = true;
			d /= 10;
			//update range of weekdays
			if (day - 1 < start) {
				start = day - 1;
			}
			if (day - 1 > finish) {
				finish = day - 1;
			}
		}
		
		//iterate through boolean array of weekdays and create string of weekdays
		int i = start;		
		while (i <= finish) {
			while (!daysArr[i]) {
				start = ++i;
			}	
			daysStr.append(i + 1);
			while (i < finish && daysArr[i] && daysArr[i + 1]) {
				if (daysArr[i] && daysArr[i + 1]) {	
					i++;
				}
			}
			if (i > start) {
				daysStr.append('-');
				daysStr.append(i + 1);		
			}		
			if (i < finish) {
				daysStr.append(',');				
			}
			i++;	
		}		
		return daysStr.toString();
	}
  
}
