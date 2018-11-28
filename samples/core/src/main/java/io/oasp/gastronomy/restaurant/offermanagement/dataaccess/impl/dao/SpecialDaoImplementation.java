package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import static com.querydsl.core.alias.Alias.$;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Named;

import com.querydsl.core.alias.Alias;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;

/**
 * @author JZMUDA
 *
 */
@Named
public class SpecialDaoImplementation extends ApplicationMasterDataDaoImpl<SpecialEntity> implements SpecialDao {

  @Override
  protected Class<SpecialEntity> getEntityClass() {

    return SpecialEntity.class;
  }

  @Override
  public List<SpecialEntity> findSpecials(SpecialSearchCriteriaTo criteria) {

    JPQLQuery<SpecialEntity> query = findSecialListQuery(criteria);

    return query.fetch();
  }

  @Override
  public SpecialEntity findBestSpecial(SpecialSearchCriteriaTo criteria) {

    JPQLQuery<SpecialEntity> query = findSecialListQuery(criteria);
    SpecialEntity special = Alias.alias(SpecialEntity.class);
    query.orderBy($(special.getSpecialPrice()).asc());

    SpecialEntity bestSpecial = query.fetchFirst();
    return bestSpecial != null ? bestSpecial : null;
  }

  private JPQLQuery<SpecialEntity> findSecialListQuery(SpecialSearchCriteriaTo criteria) {

    SpecialEntity special = Alias.alias(SpecialEntity.class);
    JPQLQuery<SpecialEntity> query = new JPAQuery<SpecialEntity>(getEntityManager()).from($(special));

    String name = criteria.getName();
    Long offerId = criteria.getOfferId();
    LocalDateTime date = criteria.getDate();
    if (name != null && !name.isEmpty()) {
      query.where($(special.getName()).eq(name));
    }

    if (offerId != null) {
      query.where($(special.getOffer().getId()).eq(offerId));
    }

    if (date != null) {

      DayOfWeek day = date.getDayOfWeek();
      query.where($(special.getActivePeriod().getStartingDay()).loe(day));
      query.where($(special.getActivePeriod().getEndingDay()).goe(day));

      int hour = date.getHour();

      query.where($(special.getActivePeriod().getStartingHour()).loe(hour));
      query.where($(special.getActivePeriod().getEndingHour()).goe(hour));
    }
    return query;
  }

}
