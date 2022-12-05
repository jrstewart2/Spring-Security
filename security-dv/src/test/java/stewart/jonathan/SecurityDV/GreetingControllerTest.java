package stewart.jonathan.SecurityDV;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import stewart.jonathan.SecurityDV.config.SecurityConfig;
import stewart.jonathan.SecurityDV.controller.AuthController;
import stewart.jonathan.SecurityDV.controller.GreetingController;
import stewart.jonathan.SecurityDV.service.TokenService;

@WebMvcTest({GreetingController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
public class GreetingControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect().isUnauthorized());
    }

    @Test
    void rootWhenAuthenticatedThenSayHelloUser() throws Exception {
        MvcResult result = this.mvc.perform(post("token")
                .with(httpBasic("jonny", "password")))
                .andExpect(status().isOk())
                .andReturn();

        String token = result.Response().getContentAsString();

        this.mvc.perform(get("/")
                .header("Authorization", "Bearer " + token))
                .andExpect(content().string("Hello, jonny"));
    }

    @Test
    @WithMockUser
    public void rootWithMockUserStatusIsOK() throws Exception {
        this.mvc.perform(get("/")).andExpect(status().isOk());
    }
}
