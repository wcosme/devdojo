package academy.devdojo.springboot2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.request.AnimePostRequestBody;
import academy.devdojo.springboot2.request.AnimePutRequestBody;

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

		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found."));
	}

	public Anime save(AnimePostRequestBody animePostRequestBody) {
		return repository.save(Anime.builder().name(animePostRequestBody.getName()).build());
	}

	public void delete(Long id) {
		repository.delete(findById(id));
	}

	@Override
	public void replace(AnimePutRequestBody requestBody) {
		
		Anime animeDoBanco = findById(requestBody.getId());
		
		Anime anime = Anime.builder()
				.id(animeDoBanco.getId())
				.name(requestBody.getName())
				.build();
		
		repository.save(anime);
		
		
	}
}
