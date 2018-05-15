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

import fr.benoit.mabankService.dao.GerantRepository;
import fr.benoit.mabankService.domaine.Gerant;

@RestController
@RequestMapping("/gerant")
public class GerantWebService {

	@Autowired
	private GerantRepository gerantRepo;

	@PostMapping({ "", "/" })
	Gerant create(@RequestBody Gerant gerant) {
		return this.gerantRepo.save(gerant);
	}

	@DeleteMapping("/{gerantId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer gerantId) {
		this.gerantRepo.deleteById(gerantId);
	}

	@GetMapping({ "", "/" })
	List<Gerant> list() {
		return this.gerantRepo.findAll();
	}

	@GetMapping("/{gerantId}")
	Gerant read(@PathVariable Integer gerantId) {
		final Optional<Gerant> retour = this.gerantRepo.findById(gerantId);
		if (retour.isPresent()) {
			return retour.get();
		} else {
			return null;
		}
	}

	@PutMapping("/{gerantId}")
	Gerant update(@PathVariable Integer gerantId, @RequestBody Gerant gerant) {
		if (this.gerantRepo.existsById(gerantId)) {
			return this.gerantRepo.save(gerant);
		} else {
			return null;
		}
	}

}
