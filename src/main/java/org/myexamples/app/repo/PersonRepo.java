package org.myexamples.app.repo;

import org.myexamples.app.core.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

//@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepo extends PagingAndSortingRepository<Person, Long> {

}
