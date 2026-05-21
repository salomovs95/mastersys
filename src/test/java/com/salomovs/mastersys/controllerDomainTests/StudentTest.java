package com.salomovs.mastersys.controllerUnitaryTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.salomovs.mastersys.service.StudentService;
import com.salomovs.mastersys.controller.StudentController;
import com.salomovs.mastersys.dto.request.StudentRequest;
import com.salomovs.mastersys.dto.response.StudentResponse;

@WebMvcTest(StudentController.class)
public class StudentTest {

  @Autowired
  MockMvc mvc;

  @MockitoBean
  public StudentService studentService;

  @Test
  void createStudent() throws Exception {
    var expected = new StudentResponse(9l, "name", "taxId", LocalDate.now(), "gender", LocalDateTime.now(), null, null);
    when(studentService.registerStudent(Mockito.any(StudentRequest.class)))
       .thenReturn(expected);

    assertDoesNotThrow(()->{
      var res = mvc.perform(post("/students")
        .contentType(MediaType.APPLICATION_JSON)
        .content(getMockPayload()))
        .andReturn()
        .getResponse();
      assertEquals(201, res.getStatus());
      assertTrue(res.getContentAsString().contains("\"id\":9"));
     });
  }

  private String getMockPayload() {
    String mockData = """
      {
        \"name\":\"%s\",
        \"taxId\":\"%s\",
        \"birthdate\":\"%s\",
        \"gender\":\"%s\",
        \"contact\":{
          \"email\":\"%s\",
          \"mainPhoneNumber\":\"%s\",
          \"secondPhoneNumber\":\"%s\"
        },
        \"address\":{
          \"address\":\"%s\",
          \"number\":\"%s\",
          \"neighborhood\":\"%s\",
          \"complement\":\"%s\",
          \"city\":\"%s\",
          \"federalUnity\":\"%s\",
          \"zipCode\":\"%s\"
        }
      }
    """;

    return String.format(mockData,
      "rei julian",
      "18462819133838",
      LocalDate.now().minusYears(10l),
      "M",
      "julian.rei@gmail.com",
      "555-555-29922",
      "555-527-92483",
      "mabble st.",
      "1292",
      "bottswager",
      "near gas station",
      "xique xique bahia",
      "ba",
      "1637218-38");
  }

}
