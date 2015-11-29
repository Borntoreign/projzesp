package pl.lodz.p.carpooling.transit;

import org.joda.time.LocalDateTime;

import java.util.Comparator;

/**
 * Created by Mateusz Surmanski on 29.11.15.
 */
public class TransitDateComparator implements Comparator<Transit> {
    @Override
    public int compare(Transit o1, Transit o2) {
        LocalDateTime date1 = o1.getStartDateObject();
        LocalDateTime date2 = o2.getStartDateObject();

        return date1.compareTo(date2);
    }
}
