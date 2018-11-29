package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.IWeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Special;
import io.oasp.module.basic.common.api.to.AbstractEto;

/**
 * @author JZMUDA
 *
 */
public class SpecialEto extends AbstractEto implements Special {

  private static final long serialVersionUID = 12345432190L;

  private String name;

  private OfferEto offer;

  private IWeeklyPeriod activePeriod;

  private Money specialPrice;

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public OfferEto getOffer() {

    return this.offer;
  }

  public void setOffer(OfferEto offer) {

    this.offer = offer;
  }

  public IWeeklyPeriod getActivePeriod() {

    return this.activePeriod;
  }

  public void setActivePeriod(IWeeklyPeriod activePeriod) {

    this.activePeriod = activePeriod;
  }

  public Money getSpecialPrice() {

    return this.specialPrice;
  }

  public void setSpecialPrice(Money specialPrice) {

    this.specialPrice = specialPrice;
  }

}
