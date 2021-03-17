package dev.gabrieljbo.project.adapters.out.elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PersonRepository extends ElasticsearchRepository<PersonEntity, Integer> {

	public PersonEntity findById(int id);

	public List<PersonEntity> findAll();

}
