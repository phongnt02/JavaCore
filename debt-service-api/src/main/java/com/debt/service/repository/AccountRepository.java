package com.debt.service.repository;

import com.debt.service.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 12:03 AM
 */
@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findByPhoneNumber(String phoneNumber);
}
