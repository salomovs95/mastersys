package com.salomovs.mastersys.doc;

import static com.salomovs.mastersys.doc.example.Exception.EXCEPTION_MESSAGE;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salomovs.mastersys.doc.example.GraduationExample;
import com.salomovs.mastersys.dto.request.GraduationRequest;
import com.salomovs.mastersys.dto.response.ExceptionResponse;
import com.salomovs.mastersys.dto.response.GraduationResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IGraduationController {

  final String PAGE_EXAMPLE = """
    {
      \"page\":0,
      \"size\":100
    }
  """;

  @Tag(name="Graduations")
  @Operation(summary="Handles graduation creation")
  @ApiResponses({
    @ApiResponse(responseCode="201", content=@Content(schema=@Schema(
      implementation=GraduationResponse.class,
      example=GraduationExample.GRADUATION_RESPONSE_EXAMPLE
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
  public GraduationResponse insertGraduation(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=GraduationRequest.class,
      example=GraduationExample.GRADUATION_RESPONSE_EXAMPLE
    )))
    GraduationRequest body
  );

  @Tag(name="Graduations")
  @Operation(summary="Handles graduation paginated listing")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      example=GraduationExample.PAGE_RESPONSE_EXAMPLE
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
  public Page<GraduationResponse> listGraduations(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId,

    @Parameter(required=false, example=PAGE_EXAMPLE)
    Pageable page
  );

  @Tag(name="Graduations")
  @Operation(summary="Handles graduation info retrieval")
  @ApiResponses({
    @ApiResponse(responseCode="204", content=@Content(schema=@Schema(
      implementation=GraduationResponse.class,
      example=GraduationExample.GRADUATION_RESPONSE_EXAMPLE
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
  public GraduationResponse findGraduation(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId,

    @Parameter(name="graduation_id", required=true, example="999")
    Long graduationId
  );

  @Tag(name="Graduations")
  @Operation(summary="Handles graduation update")
  @ApiResponses({
    @ApiResponse(responseCode="204", content=@Content(schema=@Schema())),
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
  public void updateGraduation(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId,

    @Parameter(name="graduation_id", required=true, example="999")
    Long graduationId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=GraduationRequest.class,
      example=GraduationExample.GRADUATION_REQUEST_EXAMPLE
    )))
    GraduationRequest body
  );

}
