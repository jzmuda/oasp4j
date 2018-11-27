package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import java.util.Date;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * @author JZMUDA
 *
 */
public class SpecialSearchCriteriaTo extends SearchCriteriaTo {

  /**
   * The constructor.
   */
  public SpecialSearchCriteriaTo() {

    super();
  }

  /** UID for serialization. */
  private static final long serialVersionUID = 1L;

  private String name;

  private Long offerId;

  private Date date;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return offerId
   */
  public Long getOfferId() {

    return this.offerId;
  }

  /**
   * @param offerId new value of {@link #getofferId}.
   */
  public void setOfferId(Long offerId) {

    this.offerId = offerId;
  }

  /**
   * @return date
   */
  public Date getDate() {

    return this.date;
  }

  /**
   * @param date new value of {@link #getdate}.
   */
  public void setDate(Date date) {

    this.date = date;
  }

}
