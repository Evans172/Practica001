package com.example.demo.servicelmpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository PostRepository;

	@Override
	public PostEntity create(PostEntity post) {
		// TODO Auto-generated method stub
		return PostRepository.save(post);
	}


	@Override
	public PostEntity update(PostEntity post) {
		// TODO Auto-generated method stub
		return PostRepository.save(post);
	}

	@Override
	public void delete(Long id) {
		PostRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostEntity read(Long id) {
		// TODO Auto-generated method stub
		return PostRepository.findById(id).get();
	}


	@Override
	public List<PostEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
