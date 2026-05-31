package com.salomovs.mastersys.doc;

import static com.salomovs.mastersys.doc.example.Exception.EXCEPTION_MESSAGE;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salomovs.mastersys.doc.example.ModalityExample;
import com.salomovs.mastersys.dto.request.ModalityRequest;
import com.salomovs.mastersys.dto.response.ExceptionResponse;
import com.salomovs.mastersys.dto.response.ModalityResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IModalityController {

  final String PAGE_EXAMPLE = """
    {
      \"page\":0,
      \"size\":100
    }
  """;

  @Tag(name="Modalities")
  @Operation(summary="Handles modality creation")
  @ApiResponses({
    @ApiResponse(responseCode="201", content=@Content(schema=@Schema(
      implementation=ModalityResponse.class,
      example=ModalityExample.MODALITY_RESPONSE_EXAMPLE
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
  public ModalityResponse createModality(
    @RequestBody(content=@Content(schema=@Schema(
      implementation=ModalityRequest.class,
      example=ModalityExample.MODALITY_REQUEST_EXAMPLE
    )))
    ModalityRequest body
  );

  @Tag(name="Modalities")
  @Operation(summary="Handles modality paginated listing")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      example=ModalityExample.PAGE_RESPONSE_EXAMPLE
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
  public Page<ModalityResponse> listModalities(
    @Parameter(required=false, example=PAGE_EXAMPLE)
    Pageable page
  );

  @Tag(name="Modalities")
  @Operation(summary="Handles modality info retrieval")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      implementation=ModalityResponse.class,
      example=ModalityExample.MODALITY_RESPONSE_EXAMPLE
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
  public ModalityResponse findModality(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId
  );

  @Tag(name="Modalities")
  @Operation(summary="Handles modality update")
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
  public void updateModality(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=ModalityRequest.class,
      example=ModalityExample.MODALITY_REQUEST_EXAMPLE
    )))
    ModalityRequest body
  );

}
