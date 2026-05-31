package com.salomovs.mastersys.doc;

import static com.salomovs.mastersys.doc.example.Exception.EXCEPTION_MESSAGE;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salomovs.mastersys.doc.example.PlanExample;
import com.salomovs.mastersys.dto.request.PlanRequest;
import com.salomovs.mastersys.dto.response.ExceptionResponse;
import com.salomovs.mastersys.dto.response.PlanResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IPlanController {

  final String PAGE_EXAMPLE = """
    {
      \"page\":0,
      \"size\":100
    }
  """;

  @Tag(name="Plans")
  @Operation(summary="Handles plan creation")
  @ApiResponses({
    @ApiResponse(responseCode="201", content=@Content(schema=@Schema(
      implementation=PlanResponse.class,
      example=PlanExample.PLAN_RESPONSE_EXAMPLE
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
  public PlanResponse createPlan(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=PlanRequest.class,
      example=PlanExample.PLAN_REQUEST_EXAMPLE
    )))
    PlanRequest body
  );

  @Tag(name="Plans")
  @Operation(summary="Handles plan paginated listing")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      implementation=PlanResponse.class,
      example=PlanExample.PAGE_RESPONSE_EXAMPLE
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
  public Page<PlanResponse> listPlans(
    @Parameter(name="plan_id", required=true, example="999")
    Long modalityId,

    @Parameter(required=false, example=PAGE_EXAMPLE)
    Pageable page
  );

  @Tag(name="Plans")
  @Operation(summary="Handles plan info retrieval")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      implementation=PlanResponse.class,
      example=PlanExample.PLAN_RESPONSE_EXAMPLE
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
  public PlanResponse findPlanInfo(
    @Parameter(name="plan_id", required=true, example="999")
    Long planId
  );

  @Tag(name="Plans")
  @Operation(summary="Handles plan update")
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
  public void updatePlan(
    @Parameter(name="modality_id", required=true, example="999")
    Long modalityId,

    @Parameter(name="plan_id", required=true, example="999")
    Long planId,

    @RequestBody(content=@Content(schema=@Schema(
      implementation=PlanRequest.class,
      example=PlanExample.PLAN_REQUEST_EXAMPLE
    )))
    PlanRequest body
  );

}
