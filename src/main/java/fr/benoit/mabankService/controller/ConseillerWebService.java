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

import fr.benoit.mabankService.dao.ConseillerRepository;
import fr.benoit.mabankService.domaine.Conseiller;

@RestController
@RequestMapping("/conseiller")
public class ConseillerWebService {

	@Autowired
	private ConseillerRepository conseillerRepo;

	@PostMapping({ "", "/" })
	Conseiller create(@RequestBody Conseiller conseiller) {
		return this.conseillerRepo.save(conseiller);
	}

	@DeleteMapping("/{conseillerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer conseillerId) {
		this.conseillerRepo.deleteById(conseillerId);
	}

	@GetMapping({ "", "/" })
	List<Conseiller> list() {
		return this.conseillerRepo.findAll();
	}

	@GetMapping("/{conseillerId}")
	Conseiller read(@PathVariable Integer conseillerId) {
		final Optional<Conseiller> retour = this.conseillerRepo.findById(conseillerId);
		if (retour.isPresent()) {
			return retour.get();
		} else {
			return null;
		}
	}

	@PutMapping("/{conseillerId}")
	Conseiller update(@PathVariable Integer conseillerId, @RequestBody Conseiller conseiller) {
		if (this.conseillerRepo.existsById(conseillerId)) {
			return this.conseillerRepo.save(conseiller);
		} else {
			return null;
		}
	}
}
