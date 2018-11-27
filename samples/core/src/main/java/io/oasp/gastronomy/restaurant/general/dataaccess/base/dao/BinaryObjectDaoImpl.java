package io.oasp.gastronomy.restaurant.general.dataaccess.base.dao;

import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.BinaryObjectEntity;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.BinaryObjectDao;

/**
 * Implementation of {@link BinaryObjectDao}.
 *
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
