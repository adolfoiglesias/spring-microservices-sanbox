/**
 * 
 */
package com.calarix.microservices.comment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calarix.microservices.comment.model.Comment;
import com.calarix.microservices.comment.service.CommentService;

/**
 * @author amich
 *
 */
@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("reservation/{reservationId}")
	public ResponseEntity<List<Comment>> list(@PathVariable Long reservationId){
		return ResponseEntity.accepted().body(commentService.list(reservationId));
	}
	
	@PostMapping
	public ResponseEntity<Comment> save(@RequestBody @Valid Comment comment){
		commentService.save(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body(comment);
	}
	

}
