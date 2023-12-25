package ru.tagirov.Web.blog.aplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String anons;
    private String text;
    private int views;

    public Post() {
    }

    public Post(String title, String anons, String text) {
        this.title = title;
        this.anons = anons;
        this.text = text;
    }
}
