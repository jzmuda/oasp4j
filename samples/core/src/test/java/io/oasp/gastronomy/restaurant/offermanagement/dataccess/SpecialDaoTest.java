package io.oasp.gastronomy.restaurant.offermanagement.dataccess;

import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.OfferDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author JZMUDA
 *
 */
@Transactional
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpecialDaoTest extends ComponentTest {

  private static String SPECIAL_NAME = "dummy";

  private static Money specialPrice = new Money(new BigDecimal("10.00"));

  @Inject
  private OfferDao offerDao;

  @Inject
  private SpecialDao specialDao;

  @Test
  public void testNotExists() {

    assertFalse(this.specialDao.exists(-1L));
  }

  @Test
  public void createNewWithId() {

    SpecialEntity special =
        makeSpecialEntityPriceDateOffer(makeOffer("My Offer", 100L), "My Special", LocalDateTime.now(), 10L);

    this.specialDao.save(special);

    assertThat(special.getId()).isNotNull();

  }

  @Test
  public void testFindSpecials() {

    // given
    OfferEntity offer1 = makeOffer("My Offer1", 100L);
    LocalDateTime timeOfOffer1 = LocalDateTime.of(2018, 11, 29, 11, 0);

    SpecialEntity special1 = makeSpecialEntityPriceDateOffer(offer1, "My Special1", timeOfOffer1, 10L);
    SpecialEntity savedSpecial1 = this.specialDao.save(special1);

    OfferEntity offer2 = offer1;
    LocalDateTime timeOfOffer2 = timeOfOffer1;
    SpecialEntity special2 = makeSpecialEntityPriceDateOffer(offer2, "My Special2", timeOfOffer2, 11L);
    SpecialEntity savedSpecial2 = this.specialDao.save(special2);

    OfferEntity offer3 = offer1;
    LocalDateTime timeOfOffer3 = timeOfOffer1;
    SpecialEntity special3 = makeSpecialEntityPriceDateOffer(offer3, "My Special3", timeOfOffer3, 11L);
    SpecialEntity savedSpecial3 = this.specialDao.save(special3);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    // when
    List<SpecialEntity> currentSpecials = this.specialDao.findSpecials(criteria);

    // then
    assertThat(currentSpecials).contains(savedSpecial1);
    assertThat(currentSpecials).contains(savedSpecial2);
    assertThat(currentSpecials).contains(savedSpecial3);

  }

  @Test
  public void testFindSpecialsByHour() {

    // given
    OfferEntity offer1 = makeOffer("My Offer1", 100L);
    LocalDateTime timeOfOffer1 = LocalDateTime.of(2018, 11, 29, 11, 0);

    SpecialEntity special1 = makeSpecialEntityPriceDateOffer(offer1, "My Special1", timeOfOffer1, 10L);
    SpecialEntity savedSpecial1 = this.specialDao.save(special1);

    OfferEntity offer2 = makeOffer("My Offer2", 100L);
    LocalDateTime timeOfOffer2 = timeOfOffer1;
    SpecialEntity special2 = makeSpecialEntityPriceDateOffer(offer2, "My Special2", timeOfOffer2, 11L);
    SpecialEntity savedSpecial2 = this.specialDao.save(special2);

    OfferEntity offer3 = makeOffer("My Offer3", 100L);
    LocalDateTime timeOfOffer3 = LocalDateTime.of(2018, 11, 29, 18, 0);
    SpecialEntity special3 = makeSpecialEntityPriceDateOffer(offer3, "My Special3", timeOfOffer3, 11L);
    SpecialEntity savedSpecial3 = this.specialDao.save(special3);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setDate(timeOfOffer1);
    // when
    List<SpecialEntity> currentSpecials = this.specialDao.findSpecials(criteria);

    // then
    assertThat(currentSpecials).contains(savedSpecial1);
    assertThat(currentSpecials).contains(savedSpecial2);
    assertThat(currentSpecials).doesNotContain(savedSpecial3);

  }

  @Test
  public void testFindBestSpecial() {

    // given
    OfferEntity offer = makeOffer("My Offer", 100L);

    LocalDateTime timeOfOffer1 = LocalDateTime.of(2018, 11, 29, 11, 0);

    SpecialEntity special1 = makeSpecialEntityPriceDateOffer(offer, "My Special1", timeOfOffer1, 10L);
    SpecialEntity savedSpecial1 = this.specialDao.save(special1);

    LocalDateTime timeOfOffer2 = timeOfOffer1;
    SpecialEntity special2 = makeSpecialEntityPriceDateOffer(offer, "My Special2", timeOfOffer2, 11L);
    SpecialEntity savedSpecial2 = this.specialDao.save(special2);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    // when
    SpecialEntity bestSpecial = this.specialDao.findBestSpecial(criteria);

    // then
    assertThat(bestSpecial).isEqualTo(savedSpecial1);

  }

  @Test
  public void testFindBestSpecialByHour() {

    // given
    OfferEntity offer = makeOffer("My Offer", 100L);

    LocalDateTime timeOfOffer1 = LocalDateTime.of(2018, 11, 29, 11, 0);

    SpecialEntity special1 = makeSpecialEntityPriceDateOffer(offer, "My Special1", timeOfOffer1, 10L);
    SpecialEntity savedSpecial1 = this.specialDao.save(special1);

    LocalDateTime timeOfOffer2 = timeOfOffer1;
    SpecialEntity special2 = makeSpecialEntityPriceDateOffer(offer, "My Special2", timeOfOffer2, 11L);
    SpecialEntity savedSpecial2 = this.specialDao.save(special2);

    LocalDateTime timeOfOffer3 = LocalDateTime.of(2018, 11, 29, 20, 0);
    SpecialEntity special3 = makeSpecialEntityPriceDateOffer(offer, "My Special3", timeOfOffer3, 11L);
    SpecialEntity savedSpecial3 = this.specialDao.save(special3);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setDate(timeOfOffer1);
    // when
    List<SpecialEntity> currentSpecials = this.specialDao.findSpecials(criteria);

    // then
    assertThat(currentSpecials).contains(savedSpecial1);
    assertThat(currentSpecials).contains(savedSpecial2);
    assertThat(currentSpecials).doesNotContain(savedSpecial3);

  }

  @Test
  public void testFindSpecialOfferByOffer() {

    // given
    OfferEntity offer1 = makeOffer("My Offer1", 100L);

    LocalDateTime timeOfOffer1 = LocalDateTime.of(2018, 11, 29, 11, 0);

    SpecialEntity special1 = makeSpecialEntityPriceDateOffer(offer1, "My Special1", timeOfOffer1, 10L);
    SpecialEntity savedSpecial1 = this.specialDao.save(special1);

    OfferEntity offer2 = makeOffer("My Offer2", 100L);
    LocalDateTime timeOfOffer2 = timeOfOffer1;
    SpecialEntity special2 = makeSpecialEntityPriceDateOffer(offer2, "My Special2", timeOfOffer2, 11L);
    this.specialDao.save(special2);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setOfferId(offer1.getId());
    // when
    List<SpecialEntity> currentSpecials = this.specialDao.findSpecials(criteria);

    // then
    assertThat(currentSpecials).containsOnly(savedSpecial1);

  }

  @Test
  public void testFindSpecialOfferByName() {

    // given
    OfferEntity offer1 = makeOffer("My Offer1", 100L);

    LocalDateTime timeOfOffer1 = LocalDateTime.of(2018, 11, 29, 11, 0);

    SpecialEntity special1 = makeSpecialEntityPriceDateOffer(offer1, "My Special1", timeOfOffer1, 10L);
    SpecialEntity savedSpecial1 = this.specialDao.save(special1);

    OfferEntity offer2 = offer1;
    LocalDateTime timeOfOffer2 = timeOfOffer1;
    SpecialEntity special2 = makeSpecialEntityPriceDateOffer(offer2, "My Special2", timeOfOffer2, 11L);
    this.specialDao.save(special2);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setName("My Special1");
    // when
    List<SpecialEntity> currentSpecials = this.specialDao.findSpecials(criteria);

    // then
    assertThat(currentSpecials).containsOnly(savedSpecial1);

  }

  private SpecialEntity makeSpecialEntityPriceDateOffer(OfferEntity offer, String name, LocalDateTime date,
      long price) {

    SpecialEntity special = new SpecialEntity();
    assertThat(special.getId()).isNull();
    special.setName(name);
    special.setSpecialPrice(new Money(price));
    WeeklyPeriodEmbeddable activePeriod = makePeriod(date);
    special.setActivePeriod(activePeriod);
    special.setOffer(offer);
    return special;
  }

  private OfferEntity makeOffer(String name, long price) {

    OfferEntity offer = new OfferEntity();
    offer.setName(name);
    offer.setPrice(new Money(price));
    this.offerDao.save(offer);
    return offer;
  }

  private WeeklyPeriodEmbeddable makePeriod(LocalDateTime date) {

    WeeklyPeriodEmbeddable period = new WeeklyPeriodEmbeddable();
    period.setEndingDay(date.getDayOfWeek().plus(1));
    period.setStartingDay(date.getDayOfWeek());

    period.setStartingHour(date.getHour());
    period.setEndingHour(date.getHour() + 1);
    return period;
  }

}
