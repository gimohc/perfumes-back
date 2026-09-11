package com.ruml.ecommerce.core.perfume.dao;

import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.perfume.entity.PerfumeEntity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;

import com.ruml.ecommerce.core.perfume.port.PerfumePort;

public interface PerfumeDao extends Dao<PerfumeEntity, PerfumeId>, PerfumePort {
}
