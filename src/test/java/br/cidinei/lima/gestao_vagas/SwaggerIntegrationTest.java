package br.cidinei.lima.gestao_vagas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SwaggerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAllowAccessToSwaggerUi() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/swagger-ui/index.html"))
                .andDo(result -> System.out.println("Status: " + result.getResponse().getStatus()))
                .andDo(result -> System.out.println("Body: " + result.getResponse().getContentAsString()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldAllowAccessToApiDocs() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs"))
                .andDo(result -> System.out.println("Docs Status: " + result.getResponse().getStatus()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldAllowAccessToApiDocsTrailingSlash() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs/"))
                .andDo(result -> System.out.println("DocsSlash Status: " + result.getResponse().getStatus()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldAllowAccessToSwaggerConfig() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs/swagger-config"))
                .andDo(result -> System.out.println("Config Status: " + result.getResponse().getStatus()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
