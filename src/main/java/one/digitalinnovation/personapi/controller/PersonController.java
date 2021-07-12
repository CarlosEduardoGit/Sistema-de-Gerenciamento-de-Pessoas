package one.digitalinnovation.personapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/peoples")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	
	@GetMapping
	public List<Person> listar() {
		return personService.listar();
	}
	
	@GetMapping("/{id}")
	public Person buscarPorCodigo(@PathVariable Long id) {
		return personService.buscarPorCodigo(id);
	}
	
	@PostMapping
	public Person inserir(@RequestBody Person person) {
		return personService.salvar(person);
	}
	
	@PutMapping
	public Person editar(@RequestBody Person person) {
		return personService.editar(person);
	}
	
	@DeleteMapping("/{id}")
	public Person excluir(@PathVariable Long id) {
		return personService.excluir(id);
	}
}
