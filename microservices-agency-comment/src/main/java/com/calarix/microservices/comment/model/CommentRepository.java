/**
 * 
 */
package com.calarix.microservices.comment.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author amich
 *
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment, Long>{
	
	@Query("{reservationID:?0}")
	public List<Comment> findAllByReservationId(Long reservationID);

}
