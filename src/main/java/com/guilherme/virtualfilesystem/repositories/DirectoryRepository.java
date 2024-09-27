package com.guilherme.virtualfilesystem.repositories;

import com.guilherme.virtualfilesystem.models.Directory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectoryRepository extends JpaRepository<Directory, Long> {
    List<Directory> findByParentIsNull();
}
