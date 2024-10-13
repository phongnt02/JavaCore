package com.debt.service.repository;

import com.debt.service.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 10:57 PM
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    RoleEntity getByName(String name);
}
