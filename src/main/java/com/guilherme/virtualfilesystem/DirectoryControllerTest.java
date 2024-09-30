//package com.guilherme.virtualfilesystem;
//
//import com.guilherme.virtualfilesystem.models.Directory;
//import com.guilherme.virtualfilesystem.repositories.DirectoryRepository;
//import org.testng.annotations.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.testng.AssertJUnit.assertFalse;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class DirectoryControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private DirectoryRepository directoryRepository;
//
//    @Test
//    void shouldReturn200WhenGettingDirectories() throws Exception {
//        mockMvc.perform(get("/api/directories"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void shouldCreateDirectory() throws Exception {
//        String directoryJson = "{\"name\":\"Diretório Teste\", \"parent\":null}";
//
//        mockMvc.perform(post("/api/directories")
//                        .contentType("application/json")
//                        .content(directoryJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Diretório Teste"))
//                .andExpect(jsonPath("$.id").isNotEmpty());
//    }
//
//    @Test
//    void shouldReturnListOfDirectories() throws Exception {
//        Directory rootDirectory = new Directory();
//        rootDirectory.setName("Diretório Raiz");
//        directoryRepository.save(rootDirectory);
//
//        mockMvc.perform(get("/api/directories"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(jsonPath("$[0].name").value("Diretório Raiz"));
//    }
//
//    @Test
//    void shouldUpdateDirectory() throws Exception {
//        Directory directory = new Directory();
//        directory.setName("Diretório Antigo");
//        directoryRepository.save(directory);
//
//        String updatedDirectoryJson = "{\"name\":\"Diretório Atualizado\", \"parent\":null}";
//
//        mockMvc.perform(put("/api/directories/" + directory.getId())
//                        .contentType("application/json")
//                        .content(updatedDirectoryJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Diretório Atualizado"));
//    }
//
//    @Test
//    void shouldDeleteDirectory() throws Exception {
//        Directory directory = new Directory();
//        directory.setName("Diretório a Deletar");
//        directoryRepository.save(directory);
//
//        mockMvc.perform(delete("/api/directories/" + directory.getId()))
//                .andExpect(status().isNoContent());
//
//        boolean exists = directoryRepository.existsById(directory.getId());
//        assertFalse(exists);
//    }
//}
