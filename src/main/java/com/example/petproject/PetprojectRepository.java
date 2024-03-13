package com.example.petproject;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetprojectRepository extends ElasticsearchRepository<Petproject,String>{
    List<Petproject> findByType(String type);
}
