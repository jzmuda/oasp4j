package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;

/**
 * @author JZMUDA
 *
 */
public interface ISpecialEntity {

  public String getName();

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name);

  /**
   * @return offer
   */
  public OfferEntity getOffer();

  /**
   * @param offer new value of {@link #getoffer}.
   */
  public void setOffer(OfferEntity offer);

  /**
   * @return activePeriod
   */
  public WeeklyPeriodEmbeddable getActivePeriod();

  /**
   * @param activePeriod new value of {@link #getactivePeriod}.
   */
  public void setActivePeriod(IWeeklyPeriod activePeriod);

  /**
   * @return specialPrice
   */
  public Money getSpecialPrice();

  /**
   * @param specialPrice new value of {@link #getspecialPrice}.
   */
  public void setSpecialPrice(Money specialPrice);
}
