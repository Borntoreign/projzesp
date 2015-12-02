package pl.lodz.p.carpooling.search;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import pl.lodz.p.carpooling.address.City;

/**
 * Created by Mateusz Surmanski on 29.11.15.
 */
public class SearchTransitBean {
    private City startCity;
    private City endCity;
    private LocalDateTime date;

    public SearchTransitBean(City startCity, City endCity, String date, String time) {
        if(date != null) {
            String[] dateSplit = date.split("-");
            String[] timeSplit = time.split(":");
            Integer year = Integer.valueOf(dateSplit[2]);
            Integer monthOfYear = Integer.valueOf(dateSplit[1]);
            Integer dayOfMonth = Integer.valueOf(dateSplit[0]);
            Integer hourOfDay = Integer.valueOf(timeSplit[0]);
            Integer minuteOfHour = Integer.valueOf(timeSplit[1]);
            this.date = new LocalDateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour);
        }
    }

    public SearchTransitBean(City startCity, City endCity) {
        this.startCity = startCity;
        this.endCity = endCity;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
