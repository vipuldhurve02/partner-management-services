package io.mosip.pms.device.regdevice.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.pms.device.regdevice.entity.RegRegisteredDeviceHistory;

@Repository
public interface RegRegisteredDeviceHistoryRepository extends JpaRepository<RegRegisteredDeviceHistory, String> {
	
	@Query(value = "(select * from registered_device_master_h rdh WHERE code = ?1 AND eff_dtimes<= ?2 and is_active=true and(is_deleted is null or is_deleted =false) ORDER BY eff_dtimes DESC) LIMIT 1 ", nativeQuery = true)
	RegRegisteredDeviceHistory findRegisteredDeviceHistoryByIdAndEffTimes(String code, LocalDateTime effTimes);
	
	@Query(value = "(select * from registered_device_master_h rdh WHERE code = ?1 AND provider_id=?2 AND eff_dtimes<= ?3 and (is_deleted is null or is_deleted =false) ORDER BY eff_dtimes DESC) LIMIT 1 ", nativeQuery = true)
	RegRegisteredDeviceHistory findRegisteredDeviceHistoryByIdDpIdAndEffTimes(String code, String dpId,
			LocalDateTime effTimes);

	@Query(value = "(select * from registered_device_master_h rdh WHERE code = ?1 AND eff_dtimes<= ?2 AND upper(purpose)= ?3 and is_active=true and(is_deleted is null or is_deleted =false) ORDER BY eff_dtimes DESC) LIMIT 1 ", nativeQuery = true)
	RegRegisteredDeviceHistory findRegisteredDeviceHistoryByIdAndEffTimesAndPurpose(String code, LocalDateTime effTimes,
			String purpose);
}
