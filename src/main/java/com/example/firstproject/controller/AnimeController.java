package com.example.firstproject.controller;

import com.example.firstproject.domain.Anime;
import com.example.firstproject.requests.AnimePostRequestBody;
import com.example.firstproject.requests.AnimePutRequestBody;
import com.example.firstproject.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        return ResponseEntity.ok(animeService.findById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(animeService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody animePostRequestBody) {
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
