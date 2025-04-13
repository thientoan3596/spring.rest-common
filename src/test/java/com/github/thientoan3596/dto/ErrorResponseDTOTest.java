package com.github.thientoan3596.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ErrorResponseDTOTest {
  @Nested
  class ConstructorTest {
    @Test
    void testNoArgsConstructor() {
      ErrorResponseDTO errorResponse = new ErrorResponseDTO();
      assertNull(errorResponse.getMessage());
      assertNull(errorResponse.getError());
      assertNull(errorResponse.getStatus());
      assertFalse(errorResponse.isFormValidationError());
      assertNull(errorResponse.getErrors());
    }

    @Test
    void testAllArgsConstructor() {
      ErrorResponseDTO errorResponse =
          new ErrorResponseDTO(
              "message example",
              "error example",
              HttpStatus.BAD_REQUEST,
              false,
              Collections.emptyList());
      assertEquals("message example", errorResponse.getMessage());
      assertEquals("error example", errorResponse.getError());
      assertEquals(HttpStatus.BAD_REQUEST, errorResponse.getStatus());
      assertFalse(errorResponse.isFormValidationError());
    }
  }

  @Nested
  class BuilderTest {
    @Test
    void testBuilder() {
      ErrorResponseDTO errorResponse =
          ErrorResponseDTO.builder()
              .message("message")
              .error("error")
              .status(HttpStatus.FORBIDDEN)
              .isFormValidationError(true)
              .errors(null)
              .build();
      assertEquals("message", errorResponse.getMessage());
      assertEquals("error", errorResponse.getError());
      assertEquals(HttpStatus.FORBIDDEN, errorResponse.getStatus());
      assertTrue(errorResponse.isFormValidationError());
      assertNull(errorResponse.getErrors());
    }
  }
}
