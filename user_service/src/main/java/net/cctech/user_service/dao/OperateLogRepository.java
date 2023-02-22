package net.cctech.user_service.dao;

import net.cctech.user_service.domain.OperateLog;
import net.cctech.user_service.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Can.Ru
 */

public interface OperateLogRepository extends JpaRepository<OperateLog,Integer> {

}
