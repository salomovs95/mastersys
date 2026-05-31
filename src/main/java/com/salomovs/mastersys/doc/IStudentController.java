package com.salomovs.mastersys.doc;

import static com.salomovs.mastersys.doc.example.Exception.EXCEPTION_MESSAGE;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salomovs.mastersys.doc.example.StudentExample;
import com.salomovs.mastersys.dto.filter.StudentFilter;
import com.salomovs.mastersys.dto.request.StudentRequest;
import com.salomovs.mastersys.dto.response.ExceptionResponse;
import com.salomovs.mastersys.dto.response.StudentResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IStudentController {

  final String PAGE_EXAMPLE = """
    {
      \"page\":0,
      \"size\":100
    }
  """;

  @Tag(name="Students")
  @Operation(summary="Handles student registry insertion")
  @ApiResponses({
    @ApiResponse(responseCode="201", content=@Content(schema=@Schema(
      implementation=StudentResponse.class,
      example=StudentExample.STUDENT_RESPONSE_EXAMPLE
    ))),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public StudentResponse registerStudent(
    @RequestBody(required=true, content=@Content(schema=@Schema(
      implementation=StudentRequest.class,
      example=StudentExample.STUDENT_REQUEST_EXAMPLE
    )))
    StudentRequest req
  );

  @Tag(name="Students")
  @Operation(summary="Handles student registry retrieval")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      implementation=StudentResponse.class,
      example=StudentExample.STUDENT_RESPONSE_EXAMPLE
    ))),
    @ApiResponse(responseCode="404", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public StudentResponse findStudent(
    @Parameter(name="student_id", required=true, example="999")
    Long id
  );

  @Tag(name="Students")
  @Operation(summary="Handles student registry paginated filtering")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      example=StudentExample.PAGE_RESPONSE_EXAMPLE
    ))),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public Page<StudentResponse> listStudents(
    @Parameter(required=false)
    StudentFilter filter,

    @Parameter(required=false, example=PAGE_EXAMPLE)
    Pageable page
  );

  @Tag(name="Students")
  @Operation(summary="Handles student registry updates")
  @ApiResponses({
    @ApiResponse(responseCode="204", content=@Content()),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="404", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public void updateStudentRegistry(
    @Parameter(name="student_id", required=true, example="999")
    Long id,

    @RequestBody(required=true, content=@Content(schema=@Schema(
      implementation=StudentRequest.class,
      example=StudentExample.STUDENT_REQUEST_EXAMPLE
    )))
    StudentRequest req
  );

  @Tag(name="Students")
  @Operation(summary="Handles student registry deletion")
  @ApiResponses({
    @ApiResponse(responseCode="204", content=@Content()),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="404", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public void deleteStudent(
    @Parameter(name="student_id", required=true, example="999")
    Long id
  );

}
