package com.salomovs.mastersys.doc;

import static com.salomovs.mastersys.doc.example.Exception.EXCEPTION_MESSAGE;

import javax.naming.ldap.ExtendedResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salomovs.mastersys.doc.example.AttendanceExample;
import com.salomovs.mastersys.dto.request.AttendanceRequest;
import com.salomovs.mastersys.dto.response.AttendanceResponse;
import com.salomovs.mastersys.dto.response.ExceptionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IAttendanceController {

  final String PAGE_EXAMPLE = """
    {
      \"page\":0,
      \"size\":100
    }
  """;

  @Tag(name="Attendances")
  @Operation(summary="Handles student attendance registry")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      implementation=AttendanceResponse.class,
      example=AttendanceExample.ATTENDANCE_RESPONSE_EXAMPLE
    ))),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="404", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExtendedResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public AttendanceResponse createAttendance(
    @Parameter(name="registration_id", required=true, example="999")
    Long registrationId,

    @RequestBody(required=true, content=@Content( schema=@Schema(
      implementation=AttendanceRequest.class,
      example=AttendanceExample.ATTENDANCE_REQUEST_EXAMPLE
    )))
    AttendanceRequest body
  );

  @Tag(name="Attendances")
  @Operation(summary="Handles student attendance registry batch retrieval")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      example=AttendanceExample.PAGE_RESPONSE_EXAMPLE
    ))),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExtendedResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public Page<AttendanceResponse> listAttendances(
    @Parameter(required=false, example=PAGE_EXAMPLE)
    Pageable page
  );

  @Tag(name="Attendances")
  @Operation(summary="Handles student attendance info retrieval")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      implementation=AttendanceResponse.class,
      example=AttendanceExample.ATTENDANCE_RESPONSE_EXAMPLE
    ))),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="404", content=@Content(schema=@Schema(
      implementation=ExtendedResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
    implementation=ExtendedResponse.class,
    example=EXCEPTION_MESSAGE
    )))
  })
  public AttendanceResponse getAttendanceInfo(
    @Parameter(name="attendance_id", required=true, example="999")
    Long attendanceId
  );

  @Tag(name="Attendances")
  @Operation(summary="Handles student attendance registry update")
  @ApiResponses({
    @ApiResponse(responseCode="204", content=@Content()),
    @ApiResponse(responseCode="400", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="404", content=@Content(schema=@Schema(
      implementation=ExtendedResponse.class,
      example=EXCEPTION_MESSAGE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExtendedResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public void updateAttendance(
    @Parameter(name="attendance_id", required=true, example="999")
    Long attendanceId,

    @RequestBody(required=true, content=@Content( schema=@Schema(
      implementation=AttendanceRequest.class,
      example=AttendanceExample.ATTENDANCE_REQUEST_EXAMPLE
    )))
    AttendanceRequest body
  );

}
