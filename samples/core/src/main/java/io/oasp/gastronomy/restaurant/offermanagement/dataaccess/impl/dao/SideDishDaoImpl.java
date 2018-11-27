package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SideDishEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SideDishDao;

/**
 * Implementation of {@link SideDishDao}.
 *
 */
@Named
public class SideDishDaoImpl extends ApplicationMasterDataDaoImpl<SideDishEntity> implements SideDishDao {

  /**
   * The constructor.
   */
  public SideDishDaoImpl() {

    super();
  }

  @Override
  protected Class<SideDishEntity> getEntityClass() {

    return SideDishEntity.class;
  }

}
