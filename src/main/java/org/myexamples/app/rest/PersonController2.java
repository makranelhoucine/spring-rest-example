package org.myexamples.app.rest;

import org.myexamples.app.core.Person;
import org.myexamples.app.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chris Georgoulis on 24/9/2014.
 */
@RepositoryRestController
public class PersonController2 {

	@Autowired
	private PersonRepo personRepo;

	@ResponseBody
	@RequestMapping(value = "personsPage2")
	public Page<Person> getPersonsPage2(Pageable pageable) {
		Page<Person> persons = personRepo.findAll(pageable);
		return persons;
	}

	@ResponseBody
	@RequestMapping(value = "personsResource2")
	public PagedResources<Resource<Person>> getPersonsPage2Resource(PagedResourcesAssembler<Person> assembler,
			Pageable pageable) {
		Page<Person> persons = personRepo.findAll(pageable);
		return assembler.toResource(persons);
	}

}

