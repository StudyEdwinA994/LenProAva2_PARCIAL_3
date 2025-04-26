package com.universidad.matriculas_servicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.universidad.matriculas_servicio.controller.MatriculaController;
import com.universidad.matriculas_servicio.model.MatriculaModel;
import com.universidad.matriculas_servicio.service.MatriculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MatriculaController.class)
public class MatriculaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatriculaService matriculaService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testRegistrarMatricula() throws Exception {
        MatriculaModel matricula = new MatriculaModel(null, 1L, 1L);

        // Simula retorno del servidor.
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("matricula", matricula);
        respuesta.put("usuario", new HashMap<>());
        respuesta.put("asignatura", new HashMap<>());
        // Simula el servcio
        when(matriculaService.crearMatricula(matricula)).thenReturn(respuesta);

        // Ejecucion para el metodo POST.
        mockMvc.perform(post("/matriculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(matricula)))
                .andExpect(status().isOk());
    }
}
