package com.willian.springmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.willian.springmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	//Exemplo de @Query:  <field>: { $regex: /pattern/, $options: '<options>' } }
	//Link: https://docs.mongodb.com/manual/reference/operator/query/regex/
	@Query("{ 'title': {$regex: ?0, $options: 'i'} }")
	List<Post> searchByTitle(String text);
	
	//O spring data consegue configurar tipos de pesquisas no mongo baseado em alguns nomes 
	//de metodos. Para consulta posterior "Query methods"
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ {date: {$gte: ?1 } }, {date: {$lte: ?2} }, { $or: [ { 'title': {$regex: ?0, $options: 'i'} }, { 'body': {$regex: ?0, $options: 'i'} }, { 'comments.text': {$regex: ?0, $options: 'i'} } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
