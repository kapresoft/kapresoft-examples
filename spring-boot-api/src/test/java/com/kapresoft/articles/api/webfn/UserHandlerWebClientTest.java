package com.kapresoft.articles.api.webfn;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitWebConfig
class UserHandlerWebClientTest {

    private WebTestClient webTestClient;

    @BeforeEach
    void before() {
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Test
    void specificUser_WithConsumer() {
        webTestClient.get().uri("/fn/user/1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(JsonNode.class).consumeWith(response -> {
                    JsonNode userJson = response.getResponseBody();
                    assertThat(userJson).isNotNull();
                    assertThat(userJson.isNull()).isFalse();

                    assertThat(userJson.get("link").textValue())
                            .isEqualTo("/fn/user/1");
                    assertThat(userJson.get("first").textValue())
                            .isNotNull()
                            .isEqualToIgnoringCase("steve");
                });
    }

    @Test
    void specificUserJsonBody() {
        webTestClient.get().uri("/fn/user/1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.link").isEqualTo("/fn/user/1")
                .jsonPath("$.results.id").isEqualTo(1)
                .jsonPath("$.results.first").isEqualTo("Steve")

        ;
    }

    @Test
    void allUsers_ShouldReturnResponseObject() {
        UserHandler.CollectionResponseObject response = webTestClient.get().uri("/fn/user/")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(UserHandler.CollectionResponseObject.class)
                .returnResult().getResponseBody();
        assertThat(response).isNotNull();
        assertThat(response.link()).isEqualTo("/fn/user/");
    }

    @Test
    void allUsers_ShouldResponseWithJson() {
        webTestClient.get().uri("/fn/user/")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.link").isEqualTo("/fn/user/")
                .jsonPath("$.results.length()").isEqualTo(2)
                .jsonPath("$.results['1'].id").isEqualTo("1")
                .jsonPath("$.results['1'].email").isEqualTo("steve.rogers@gmail.com")
                .jsonPath("$.results['2'].id").isEqualTo("2")
                .jsonPath("$.results['2'].email").isEqualTo("linda.carter@gmail.com");
    }
}
