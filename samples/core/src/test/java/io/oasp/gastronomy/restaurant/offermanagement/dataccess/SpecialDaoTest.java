package io.oasp.gastronomy.restaurant.offermanagement.dataccess;

import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.time.DayOfWeek;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.OfferDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
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

    WeeklyPeriodEmbeddable period = new WeeklyPeriodEmbeddable();
    period.setEndingDay(DayOfWeek.WEDNESDAY);
    period.setStartingDay(DayOfWeek.MONDAY);
    period.setStartingHour(7);
    period.setEndingHour(10);

    SpecialEntity special = new SpecialEntity();
    special.setActivePeriod(period);
    special.setName(SPECIAL_NAME);
    special.setSpecialPrice(specialPrice);

    this.specialDao.save(special);

    assertThat(special.getId()).isNotNull();

  }

}
