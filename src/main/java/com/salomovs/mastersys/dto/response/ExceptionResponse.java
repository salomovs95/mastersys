package com.salomovs.mastersys.dto.response;

import java.util.List;

public record ExceptionResponse (
  Integer statusCode,
  String cause,
  List<String> errors
) {}
