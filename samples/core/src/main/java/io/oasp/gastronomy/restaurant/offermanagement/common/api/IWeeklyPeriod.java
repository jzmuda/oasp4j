package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import java.time.DayOfWeek;

/**
 * @author JZMUDA
 *
 */
public interface IWeeklyPeriod {

  public DayOfWeek getStartingDay();

  public void setStartingDay(DayOfWeek day);

  public DayOfWeek getEndingDay();

  public void setEndingDay(DayOfWeek day);

  public int getStartingHour();

  public void setStartingHour(int hour);

  public int getEndingHour();

  public void setEndingHour(int hour);

}
