package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;

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

  // @Override
  // public PaginatedListTo<SpecialEntity> findSpecial(SpecialSearchCriteriaTo criteria) {
  //
  // SpecialEntity special = Alias.alias(SpecialEntity.class);
  // EntityPathBase<SpecialEntity> alias = $(special);
  // JPAQuery<OfferEntity> query = new JPAQuery<OfferEntity>(getEntityManager()).from(alias);
  //
  // String name = criteria.getName();
  // if (name != null && !name.isEmpty()) {
  // query.where($(special.getName()).eq(name));
  // }
  //
  // Long offerId = criteria.getOfferId();
  //
  // if (offerId != null) {
  // query.where($(special.getOffer().getId()).eq(offerId));
  // }
  //
  // Date date = criteria.getDate();
  // if (date != null) {
  // LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  //
  // int day = localDate.getDayOfMonth();
  // query.where($(special.getActivePeriod().getStartingDay()).loe(DayOfWeek.of(day)));
  // query.where($(special.getActivePeriod().getEndingDay()).goe(DayOfWeek.of(day)));
  // }
  //
  // return findPaginated(criteria, query);
  // }

}
