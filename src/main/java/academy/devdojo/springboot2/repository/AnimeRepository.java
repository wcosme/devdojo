package academy.devdojo.springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.devdojo.springboot2.domain.Anime;
@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

	List<Anime> findByName(String name);
}
