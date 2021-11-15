package academy.devdojo.springboot2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.mapper.AnimeMapper;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.request.AnimePostRequestBody;
import academy.devdojo.springboot2.request.AnimePutRequestBody;

@Service
public class AnimeServiceImpl implements AnimeService {

	@Autowired
	private AnimeRepository repository;
	
	@Autowired
	private AnimeMapper mapper;

	@Override
	public Page<Anime> listAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Override
	public List<Anime> listNoPageable() {		
		return repository.findAll();
	}
	
	@Override
	public List<Anime> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Anime findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new BadRequestException("Anime not found."));
	}

	@Transactional
	public Anime save(AnimePostRequestBody animePostRequestBody) {
		return repository.save(mapper.toAnime(animePostRequestBody));
	}

	public void delete(Long id) {
		repository.delete(findById(id));
	}

	@Override
	public void replace(AnimePutRequestBody requestBody) {
		
		Anime animeDoBanco = findById(requestBody.getId());
		
		Anime anime = mapper.toAnime(requestBody);
		anime.setId(animeDoBanco.getId());
		
		repository.save(anime);		
		
	}	
}
