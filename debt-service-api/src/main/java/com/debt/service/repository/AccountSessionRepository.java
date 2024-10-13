package com.debt.service.repository;

import com.debt.service.entity.AccountSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 1:47 PM
 */
@Repository
public interface AccountSessionRepository extends CrudRepository<AccountSession, Integer> {
}
