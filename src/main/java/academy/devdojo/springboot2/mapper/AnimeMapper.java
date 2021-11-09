package academy.devdojo.springboot2.mapper;

import org.mapstruct.Mapper;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.request.AnimePostRequestBody;
import academy.devdojo.springboot2.request.AnimePutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
	
	public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);	
	public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
