package com.salomovs.mastersys.doc.example;

public interface PlanExample {

  static final String PLAN_REQUEST_EXAMPLE = """
    {
      \"name\":\"...\",
      \"monthlyPrice\":1.00,
      \"active\":true
    }
  """;

  static final String PLAN_RESPONSE_EXAMPLE = """
    {
      \"id\":999,
      \"name\":\"...\",
      \"monthlyPrice\":1.00,
      \"active\":true,
      \"modality\": """ + ModalityExample.MODALITY_RESPONSE_EXAMPLE + """
    }
  """;

  static final String PAGE_RESPONSE_EXAMPLE = """
    {
      \"page\":0,
      \"content\":[
        """ + PLAN_RESPONSE_EXAMPLE + """
      ]
    }
  """;

}
