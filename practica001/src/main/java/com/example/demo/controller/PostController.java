package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.commons.GlobalConstants.API_POST;

import com.example.demo.entity.PostEntity;
import com.example.demo.service.PostService;

@RestController
@RequestMapping(API_POST)
public class PostController {

	@Autowired
	private PostService PostService;

	@GetMapping("/all")
	public List<PostEntity> listar() {
		return PostService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostEntity> listar2(@PathVariable("id") long id) {
		PostEntity post = PostService.read(id);
		if (post!=null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Post")
	  public ResponseEntity<PostEntity> createTutorial(@RequestBody PostEntity p) {
	    try {
	      PostEntity post = PostService.create(new PostEntity(p.getId(), p.getNombre(), p.getDescripcion(),p.getPrecio(), p.getStock(), p.getEstado()));

	      return new ResponseEntity<>(post, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/post/{id}")
	  public ResponseEntity<PostEntity> updateTutorial(@PathVariable("id") long id, @RequestBody PostEntity post) {
	    PostEntity Post = PostService.read(id);

	    if (Post!=null) {
	      Post.setId(post.getId());
	      Post.setNombre(post.getNombre());
	      Post.setDescripcion(post.getDescripcion());
	      Post.setPrecio(post.getPrecio());
	      Post.setStock(post.getStock());
	      Post.setEstado(post.getEstado());
	      return new ResponseEntity<>(PostService.create(Post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/Post/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	      PostService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
