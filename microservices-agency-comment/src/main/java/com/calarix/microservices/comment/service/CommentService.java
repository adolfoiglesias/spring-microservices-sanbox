/**
 * 
 */
package com.calarix.microservices.comment.service;

import java.util.List;

import com.calarix.microservices.comment.model.Comment;

/**
 * @author amich
 *
 */
public interface CommentService {

	public void save(Comment comment);
	public List<Comment> list(Long reservationID);
	public Comment findById(Long id);
	public void delete(Long id);
	
	
	
}
