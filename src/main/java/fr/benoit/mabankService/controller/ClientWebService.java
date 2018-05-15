package fr.benoit.mabankService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.benoit.mabankService.dao.ClientRepository;
import fr.benoit.mabankService.domaine.Client;

@RestController
@RequestMapping("/client")
public class ClientWebService {

	@Autowired
	private ClientRepository clientRepo;

	@PostMapping({ "", "/" })
	Client create(@RequestBody Client client) {
		return this.clientRepo.save(client);
	}

	@DeleteMapping("/{conseillerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer clientId) {
		this.clientRepo.deleteById(clientId);
	}

	@GetMapping({ "", "/" })
	List<Client> list() {
		return this.clientRepo.findAll();
	}

	@GetMapping("/{conseillerId}")
	Client read(@PathVariable Integer clientId) {
		final Optional<Client> retour = this.clientRepo.findById(clientId);
		if (retour.isPresent()) {
			return retour.get();
		} else {
			return null;
		}
	}

	@PutMapping("/{conseillerId}")
	Client update(@PathVariable Integer clientId, @RequestBody Client client) {
		if (this.clientRepo.existsById(clientId)) {
			return this.clientRepo.save(client);
		} else {
			return null;
		}
	}
}
