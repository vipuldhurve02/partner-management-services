package io.mosip.pmp.misp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.kernel.core.dataaccess.spi.repository.BaseRepository;
import io.mosip.pmp.misp.entity.Misp;

/**
 * Repository class for fetching and updating mispid.
 * @since 1.0.0
 * @author Nagarjuna K
 */
@Repository
public interface MispRepository extends BaseRepository<Misp, Integer> {

	/**
	 * Method to fetch last updated mispid.
	 * 
	 * @return the entity.
	 */
	@Query(value = "select t.curr_seq_no,t.cr_by,t.cr_dtimes,t.upd_by,t.upd_dtimes FROM tspid_seq t where t.curr_seq_no=(select max(t.curr_seq_no) FROM tspid_seq t)", nativeQuery = true)
	Misp findLastMispId();

}
