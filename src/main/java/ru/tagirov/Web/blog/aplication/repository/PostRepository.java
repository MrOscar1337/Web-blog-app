package ru.tagirov.Web.blog.aplication.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tagirov.Web.blog.aplication.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
