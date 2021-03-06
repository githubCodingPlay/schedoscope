/**
 * Copyright 2015 Otto (GmbH & Co KG)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.schedoscope.metascope.repository;

import org.schedoscope.metascope.model.ParameterValueEntity;
import org.schedoscope.metascope.model.key.ParameterValueEntityKey;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParameterValueEntityRepository extends CrudRepository<ParameterValueEntity, ParameterValueEntityKey>,
        JpaSpecificationExecutor<ParameterValueEntity> {

    public List<ParameterValueEntity> findByKeyUrlPath(String urlPath);

    @Query("SELECT distinct(key.pKey), value FROM ParameterValueEntity p WHERE p.tableFqdn = :tableFqdn")
    public List<Object[]> findDistinctParameterValues(@Param(value = "tableFqdn") String tableFqdn);

}
