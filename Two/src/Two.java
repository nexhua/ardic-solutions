import com.ardic.two.Date;
import com.ardic.two.WeekDays;

import java.util.ArrayList;
import java.util.List;

public class Two {
    public static void main(String[] args) {

        ArrayList<Date> dates = new ArrayList<>();

        for (int i = 1900; i < 2001; i++) {
            for (int j = 1; j < 13; j++) {
                dates.add(new Date(i, j, 1));
            }
        }

        List<Date> searchedDates = dates.stream().filter(date -> date.getWeekDay() == WeekDays.SUNDAY).toList();

        System.out.format("There are %d days between %s and %s where first day of a month is sunday.\n", searchedDates.size(), new Date(), new Date(2000, 12, 31));

        System.out.println("Date format is : DD.MM.YYYY\n");
        for (Date date : searchedDates) {
            System.out.print(date + " ");
        }
    }
}
