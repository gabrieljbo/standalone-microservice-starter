package dev.gabrieljbo.project.adapters.out.elasticsearch;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.gabrieljbo.project.domain.model.Person;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoundedMapper {

    Person personEntityToPerson(PersonEntity personEntity);

    List<Person> personEntityToPerson(List<PersonEntity> personEntityList);
    
}