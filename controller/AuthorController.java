package com.example.library.controller;

import org.springframework.stereotype.Controller;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String getAllAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authorread";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorcreate";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorRepository.save(author);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdateAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authorupdate";
    }

    @GetMapping("/update/{id}")
    public String showUpdateAuthorForm(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author ID: " + id));
        model.addAttribute("author", author);
        return "authorupdateedit";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author updatedAuthor) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author ID: " + id));

        author.setName(updatedAuthor.getName());
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/confirm-delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id).orElse(null);
        model.addAttribute("author", author);
        return "authordelete";
    }

    @GetMapping("/delete")
    public String showDeleteAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authordelete";
    }

    @PostMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

}