package com.example.loginandregistration.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.loginandregistration.models.Post;
import com.example.loginandregistration.models.User;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	List<Post> findAll();
	Optional<Post> findById(Long id);
}