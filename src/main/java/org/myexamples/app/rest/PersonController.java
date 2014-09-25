package org.myexamples.app.rest;

import org.myexamples.app.core.Person;
import org.myexamples.app.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chris Georgoulis on 24/9/2014.
 */
@Controller
public class PersonController {

	@Autowired
	private PersonRepo personRepo;

	@ResponseBody
	@RequestMapping(value = "hello")
	public String sayHello() {
		return "Hello World!";
	}

//	@RequestMapping(value = "persons/search/all")
//	public PagedResources<Resource<Person>> getPersons(PagedResourcesAssembler<Person> assembler, Pageable pageable) {
//
//		Page<Person> persons = personRepo.findAll(pageable);
//		return assembler.toResource(persons);
//	}

	@ResponseBody
	@RequestMapping(value = "personsList")
	public Iterable<Person> getPersonsList() {
		Iterable<Person> persons = personRepo.findAll();
		return persons;
	}

	@ResponseBody
	@RequestMapping(value = "personsPage")
	public Page<Person> getPersonsPage(Pageable pageable) {
		Page<Person> persons = personRepo.findAll(pageable);
		return persons;
	}

	@ResponseBody
	@RequestMapping(value = "personsResource")
	public PagedResources<Resource<Person>> getPersonsPage2Resource(PagedResourcesAssembler<Person> assembler,
			Pageable pageable) {
		Page<Person> persons = personRepo.findAll(pageable);
		return assembler.toResource(persons);
	}

}

