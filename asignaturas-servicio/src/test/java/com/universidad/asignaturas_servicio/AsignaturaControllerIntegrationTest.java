package com.universidad.asignaturas_servicio;

import com.universidad.asignaturas_servicio.controller.AsignaturaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AsignaturaControllerIntegrationTest {

    @Autowired
    private AsignaturaController asignaturaController;

    private MockMvc mockMvc;

    //Config de MockMVC para controlador.
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(asignaturaController).build();
    }

    //Simula un GET con ID que no esta enla bd - espera un 404.
    @Test
    public void testObtenerAsignaturaPorIdNoExistente() throws Exception {
        mockMvc.perform(get("/asignaturas/99"))
                .andExpect(status().isNotFound());  // Espera un código de estado 404
    }
}
