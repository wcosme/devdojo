package academy.devdojo.springboot2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;

@Service
public class AnimeServiceImpl implements AnimeService {

	@Autowired
	private AnimeRepository repository;

	@Override
	public List<Anime> listAll() {
		return repository.findAll();
	}

	@Override
	public Anime findById(Long id) {

		return repository.findAll().stream().filter(anime -> anime.getId().equals(id)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found."));
	}

	public Anime save(Anime anime) {
		return repository.save(anime);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
