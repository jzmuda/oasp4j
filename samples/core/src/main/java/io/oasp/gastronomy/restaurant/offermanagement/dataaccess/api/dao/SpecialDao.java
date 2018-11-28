package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * @author JZMUDA
 *
 */
public interface SpecialDao extends MasterDataDao<SpecialEntity> {

  public List<SpecialEntity> findSpecials(SpecialSearchCriteriaTo criteria);

  public SpecialEntity findBestSpecial(SpecialSearchCriteriaTo criteria);

}