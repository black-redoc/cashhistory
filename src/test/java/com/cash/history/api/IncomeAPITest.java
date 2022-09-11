package com.cash.history.api;

import com.cash.history.model.Income;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IncomeAPITest {
    @LocalServerPort
    private int port;
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void givenEmptyDatabase_whenExecuteGetIncome_thenReturnsEmptyList() {
        // Given
        var url = "http://localhost:" + port + "/income";

        // When
        var body = restTemplate.getForEntity(url, List.class).getBody();

        // Then
        assertThat(body).isNotNull();
        assertThat(body.size()).isEqualTo(0);
    }

    @Test
    public void givenEmptyDatabase_whenExecuteGetClient_thenReturns200OK() {
        // Given
        var url = "http://localhost:" + port + "/income";

        // When
        var statusCode = restTemplate.getForEntity(url, List.class).getStatusCodeValue();

        // Then
        assertThat(statusCode).isEqualTo(200);
    }

    @Test
    public void givenEmptyDatabase_whenCreateNewIncome_thenReturnsNewIncome() {
        // Given
        var url = "http://localhost:" + port + "/income";
        var test_concept = "test_concept";
        var test_amount = 200D;
        var initDateTime = LocalDateTime.now();
        Map<String, Object> income = Map.of("concept", test_concept, "amount", test_amount);

        // When
        var response = restTemplate.postForEntity(url, income, Income.class);
        var incomeResponse = response.getBody();
        var statusCode = response.getStatusCodeValue();

        // Then
        assertThat(statusCode).isEqualTo(201);
        assert incomeResponse != null;
        assertThat(incomeResponse.getAmount()).isEqualTo(test_amount);
        assertThat(incomeResponse.getConcept()).isEqualTo(test_concept);
        assertThat(incomeResponse.getCreatedAt()).isAfter(initDateTime);
    }

    @Test
    public void givenEmptyDatabase_whenGetOneIncome_thenReturn404NOTFOUND() {
        // Given
        var nonExistingId = 21L;
        var url = "http://localhost:" + port + "/income/" + nonExistingId;
        var expectedResponse = Map.of("error", "Not found income with id " + nonExistingId);

        // When
        var response = restTemplate.getForEntity(url, HashMap.class);

        // Then
        assertThat(response.getBody()).isEqualTo(expectedResponse);
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    public void givenEmptyDatabase_whenCreateNewIncomeWithoutAmount_thenReturn400BADREQUEST() {
        // Given
        var url = "http://localhost:" + port + "/income";
        var test_concept = "test_concept";
        Map<String, Object> income = Map.of("concept", test_concept);

        // When
        var response = restTemplate.postForEntity(url, income, Income.class);
        var incomeResponse = response.getBody();
        var statusCode = response.getStatusCodeValue();

        // Then
        assertThat(statusCode).isEqualTo(400);
        assert incomeResponse != null;
    }

    @Test
    public void givenEmptyDatabase_whenCreateNewIncomeWithoutConcept_thenReturn400BADREQUEST() {
        // Given
        var url = "http://localhost:" + port + "/income";
        var test_amount = 200D;
        Map<String, Object> income = Map.of("amount", test_amount);

        // When
        var response = restTemplate.postForEntity(url, income, Income.class);
        var incomeResponse = response.getBody();
        var statusCode = response.getStatusCodeValue();

        // Then
        assertThat(statusCode).isEqualTo(400);
        assert incomeResponse != null;
    }

    @Test
    public void givenEmptyDatabase_whenDeleteANotExistentIncomeById_thenReturn404OK() {
        // Given
        var nonExistingId = 20L;
        var url = "http://localhost:" + port + "/income/" + nonExistingId;
        var expectedKey = "error";
        var expectedValue = "No class com.cash.history.model.Income entity with id %d exists!".formatted(nonExistingId);

        // When
        var response = restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Map.class);

        // Then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().keySet()).matches(e -> e.contains(expectedKey), "Containing error message");
        assertThat(response.getBody().get(expectedKey)).isEqualTo(List.of(expectedValue));
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    public void givenEmptyDatabase_whenDeleteAIncomeById_thenReturn200OK() {
        // Given
        var nonExistingId = 1L;
        var url = "http://localhost:" + port + "/income/" + nonExistingId;
        var expectedKey = "success";
        var expectedValue = true;

        // When
        var response = restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Map.class);

        // Then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().keySet()).matches(e -> e.contains(expectedKey), "Containing success message");
        assertThat(response.getBody().get(expectedKey)).isEqualTo(expectedValue);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}