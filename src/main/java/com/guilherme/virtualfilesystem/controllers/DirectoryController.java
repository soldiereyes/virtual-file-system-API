package com.guilherme.virtualfilesystem.controllers;


import com.guilherme.virtualfilesystem.models.Directory;
import com.guilherme.virtualfilesystem.repositories.DirectoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directories")
public class DirectoryController {

    private final DirectoryRepository directoryRepository;

    public DirectoryController(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Directory>> getAllDirectories() {
        List<Directory> directories = directoryRepository.findByParentIsNull();
        return ResponseEntity.ok(directories);
    }

    @PostMapping
    public ResponseEntity<Directory> createDirectory(@RequestBody Directory directory) {
        Directory savedDirectory = directoryRepository.save(directory);
        return ResponseEntity.ok(savedDirectory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirectory(@PathVariable Long id) {
        directoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Directory> updateDirectory(@PathVariable Long id, @RequestBody Directory updatedDirectory) {
        return directoryRepository.findById(id)
                .map(directory -> {
                    directory.setName(updatedDirectory.getName());
                    Directory savedDirectory = directoryRepository.save(directory);
                    return ResponseEntity.ok(savedDirectory);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
