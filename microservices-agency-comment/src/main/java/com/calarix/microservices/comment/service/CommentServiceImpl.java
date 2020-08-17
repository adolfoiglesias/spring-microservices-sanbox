/**
 * 
 */
package com.calarix.microservices.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calarix.microservices.comment.model.Comment;
import com.calarix.microservices.comment.model.CommentRepository;

/**
 * @author amich
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public Comment findById(Long id) {
		return commentRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Comment> list(Long reservationID) {
		return commentRepository.findAllByReservationId(reservationID);
	}
	
	@Override
	public void save(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public void delete(Long id) {
		commentRepository.deleteById(id);
	}
	
}
