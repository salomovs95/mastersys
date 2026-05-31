package com.salomovs.mastersys.doc;

import static com.salomovs.mastersys.doc.example.Exception.EXCEPTION_MESSAGE;

import java.util.List;

import com.salomovs.mastersys.dto.projection.MonthlyIncomes;
import com.salomovs.mastersys.dto.projection.PendingInvoice;
import com.salomovs.mastersys.dto.projection.StudentPerCity;
import com.salomovs.mastersys.dto.response.ExceptionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Reports")
public interface IReportsController {

  static final String REPORT_RESPONSE_EXAMPLE = "[]";

  @Operation(summary="Handles Financial Report Generation on Incomes")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(
      schema=@Schema(example=IReportsController.REPORT_RESPONSE_EXAMPLE)
    )),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public List<MonthlyIncomes> monthlyIncomes();

  @Operation(summary="Handles Financial Report Generation on Pending Invocies")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(
      schema=@Schema(example=IReportsController.REPORT_RESPONSE_EXAMPLE)
    )),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public List<PendingInvoice> pendingInvoices();

  @Operation(summary="Handles Operational Report Generation on Students")
  @ApiResponses({
    @ApiResponse(responseCode="200", content=@Content(schema=@Schema(
      example=IReportsController.REPORT_RESPONSE_EXAMPLE
    ))),
    @ApiResponse(responseCode="500", content=@Content(schema=@Schema(
      implementation=ExceptionResponse.class,
      example=EXCEPTION_MESSAGE
    )))
  })
  public List<StudentPerCity> studentsPerCity();

}
