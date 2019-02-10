package com.kodebee.socialnet.userprofile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodebee.socialnet.userprofile.model.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserIntegrationTest {
    private static Logger logger = LoggerFactory.getLogger(UserIntegrationTest.class);
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test user creation
     * @throws Exception
     */
    @Test
    public void test_A_createUser() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setFirstName("Harry");
        user.setLastName("Potter");
        user.setDateOfBirth(format.parse("2000-01-08"));
        user.setCity("Dallas");
        mockMvc.perform(MockMvcRequestBuilders.post("/userprofile")
        .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void test_B_getUser() throws Exception {
        logger.info(mockMvc.perform(MockMvcRequestBuilders.get("/userprofiles/name/Harry%20Potter")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).toString());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

