package one.digitalinnovation.personapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	public List<Person> listar() {
		return personRepository.findAll();
	}
	
	public Person buscarPorCodigo(Long id) {
		return personRepository.findById(id).get();
	}

	public Person salvar(Person person) {
		return personRepository.save(person);
		
	}
	
	public Person editar(Person person) {
		return personRepository.save(person);
	}
	
	public Person excluir(Long id) {
		Optional<Person> excluir = personRepository.findById(id);
		personRepository.delete(excluir.get());
		return excluir.get();
	}
	

}
