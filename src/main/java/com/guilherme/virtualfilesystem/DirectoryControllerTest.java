package com.guilherme.virtualfilesystem;

import com.guilherme.virtualfilesystem.models.Directory;
import com.guilherme.virtualfilesystem.repositories.DirectoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.AssertJUnit.assertFalse;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DirectoryRepository directoryRepository;

    private Directory testDirectory;

    @BeforeEach
    void setup() {
        testDirectory = new Directory();
        testDirectory.setName("Test Directory");
        directoryRepository.save(testDirectory);
    }

    @Test
    void shouldReturn200WhenGettingDirectories() throws Exception {
        mockMvc.perform(get("/api/directories"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateDirectory() throws Exception {
        String directoryJson = "{\"name\":\"Novo Diretório\", \"parent\":null}";

        mockMvc.perform(post("/api/directories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(directoryJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Novo Diretório"))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void shouldDeleteDirectory() throws Exception {
        Directory directory = new Directory();
        directory.setName("Diretório a Deletar");
        directoryRepository.save(directory);

        mockMvc.perform(delete("/api/directories/" + directory.getId()))
                .andExpect(status().isNoContent());

        boolean exists = directoryRepository.existsById(directory.getId());
        assertFalse(exists);
    }

    @Test
    void shouldReturnListOfDirectories() throws Exception {
        mockMvc.perform(get("/api/directories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("Diretório Teste"));
    }

    @Test
    void shouldUpdateDirectory() throws Exception {
        String updatedDirectoryJson = "{\"name\": \"Updated Directory\"}";

        mockMvc.perform(put("/api/directories/" + testDirectory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedDirectoryJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Updated Directory")));
    }
}
