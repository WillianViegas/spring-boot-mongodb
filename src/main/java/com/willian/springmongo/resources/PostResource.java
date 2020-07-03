package com.willian.springmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.willian.springmongo.domain.Post;
import com.willian.springmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	//GetMapping(value="/{id}")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Post> findById(@PathVariable String id){
			Post obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
}
