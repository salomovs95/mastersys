package com.salomovs.mastersys.doc.example;

public interface ModalityExample {

  static final String MODALITY_RESPONSE_EXAMPLE = """
    {
      \"id\":999,
      \"name\":\"...\",
      \"active\": true
    }
  """;

  static final String MODALITY_REQUEST_EXAMPLE = """
    {
      \"name\":\"...\",
      \"active\": true
    }
  """;

  static final String PAGE_RESPONSE_EXAMPLE = """
    {
      \"page\":0,
      \"content\":[
        """ + MODALITY_RESPONSE_EXAMPLE + """
      ]
    }
  """;

}
