package ru.tagirov.Web.blog.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tagirov.Web.blog.aplication.model.Post;
import ru.tagirov.Web.blog.aplication.repository.PostRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;
    @GetMapping("/blog")
    public String blog(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String add(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String post(@RequestParam String title, @RequestParam String anons,
                       @RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String fullText(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-text";
    }

    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String update(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons,
                       @RequestParam String full_text, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setText(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String remove(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
}
