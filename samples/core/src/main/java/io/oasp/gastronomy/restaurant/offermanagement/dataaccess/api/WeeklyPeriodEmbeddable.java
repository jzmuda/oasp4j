package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import java.time.DayOfWeek;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author JZMUDA
 *
 */
@Embeddable
public class WeeklyPeriodEmbeddable implements IWeeklyPeriod {

  private DayOfWeek startingDay;

  @Max(24)
  @Min(0)
  private int startingHour;

  private DayOfWeek endingDay;

  @Max(24)
  @Min(0)
  private int endingHour;

  @Override
  public DayOfWeek getStartingDay() {

    return this.startingDay;
  }

  @Override
  public void setStartingDay(DayOfWeek day) {

    this.startingDay = day;
  }

  @Override
  public DayOfWeek getEndingDay() {

    return this.endingDay;
  }

  @Override
  public void setEndingDay(DayOfWeek day) {

    this.endingDay = day;
  }

  @Max(24)
  @Min(0)
  @Override
  public int getStartingHour() {

    return this.startingHour;
  }

  @Override
  public void setStartingHour(int hour) {

    this.endingHour = hour;
  }

  @Max(24)
  @Min(0)
  @Override
  public int getEndingHour() {

    return this.endingHour;
  }

  @Override
  public void setEndingHour(int hour) {

    this.startingHour = hour;
  }
}
