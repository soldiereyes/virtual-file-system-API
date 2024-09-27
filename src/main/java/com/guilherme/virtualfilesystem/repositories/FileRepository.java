package com.guilherme.virtualfilesystem.repositories;


import com.guilherme.virtualfilesystem.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FileRepository extends JpaRepository<File, Long> {
}
