package academy.devdojo.springboot2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.request.AnimePostRequestBody;
import academy.devdojo.springboot2.request.AnimePutRequestBody;

public interface AnimeService {
	
	Page<Anime> listAll(Pageable pageable);
	List<Anime> listNoPageable();
	List<Anime> findByName(String name);
	Anime findById(Long id);	
	Anime save(AnimePostRequestBody animePostRequestBody);
	void delete(Long id);
	void replace(AnimePutRequestBody requestBody);
	

}
