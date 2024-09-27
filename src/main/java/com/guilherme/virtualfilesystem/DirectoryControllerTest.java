package com.guilherme.virtualfilesystem;

import com.guilherme.virtualfilesystem.models.Directory;
import com.guilherme.virtualfilesystem.repositories.DirectoryRepository;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DirectoryRepository directoryRepository;

    @Test
    void shouldReturn200WhenGettingDirectories() throws Exception {
        mockMvc.perform(get("/api/directories"))
                .andExpect(status().isOk());
    }
}
