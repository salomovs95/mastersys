package com.salomovs.mastersys.doc;

import static com.salomovs.mastersys.doc.example.Exception.EXCEPTION_MESSAGE;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salomovs.mastersys.doc.example.RegistrationExample;
import com.salomovs.mastersys.dto.request.RegistrationModalityRequest;
import com.salomovs.mastersys.dto.request.RegistrationRequest;
import com.salomovs.mastersys.dto.response.ExceptionResponse;
import com.salomovs.mastersys.dto.response.RegistrationModalityResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Registrations")
public interface IRegistrationController {

  final String PAGE_EXAMPLE = """
    {
      \"page\":0,
      \"size\":100
    }
  """;

  @Operation(summary="Handles registration creation")
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
    @ApiResponse(responseCode="50p", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public void registrate(
    @Parameter(name="student", required=true, example="999")
    Long studentId,

    @Parameter(name="plan", required=true, example="999")
    Long planId,

    @Parameter(name="graduation", required=true, example="999")
    Long graduationId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=RegistrationRequest.class,
      example=RegistrationExample.REGISTRATION_REQUEST_EXAMPLE
    )))
    RegistrationRequest body
  );

  @Operation(summary="Handles registration update")
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
  public void updateRegistration(
    @Parameter(name="reg_id", required=true, example="999")
    Long regId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=RegistrationRequest.class,
      example=RegistrationExample.REGISTRATION_REQUEST_EXAMPLE
    )))
    RegistrationRequest body
  );

  @Operation(summary="Handles registration_modality update")
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
  public void updateModalityRegistration(
    @Parameter(name="registration_modality_id", required=true, example="999")
    Long regId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=RegistrationRequest.class,
      example=RegistrationExample.REG_MODALITY_REQUEST_EXAMPLE
    )))
    RegistrationModalityRequest body
  );

  @Operation(summary="Handles registrations paginated listing")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      example=RegistrationExample.PAGE_RESPONSE_EXAMPLE
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
  public Page<RegistrationModalityResponse> listRegistry(
    @Parameter(required=false, example=PAGE_EXAMPLE)
    Pageable page
  );

  @Operation(summary="Handles registrations info retrieval")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      implementation=RegistrationModalityResponse.class,
      example=RegistrationExample.REG_MODALITY_RESPONSE_EXAMPLE
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
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public RegistrationModalityResponse findRegistry(
    @Parameter(name="registration_modality_id", required=true, example="999")
    Long regId
  );

}
