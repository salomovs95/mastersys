package com.salomovs.mastersys.doc.example;

public interface GraduationExample {

  static final String GRADUATION_REQUEST_EXAMPLE = """
    {
      \"name\": \"...\"
    }
  """;

  static final String GRADUATION_RESPONSE_EXAMPLE = """
    {
      \"id\": 999,
      \"name\": \"...\",
      \"modality\": """ + ModalityExample.MODALITY_RESPONSE_EXAMPLE + """
    }
  """;

  static final String PAGE_RESPONSE_EXAMPLE = """
    {
      \"page\": 0,
      \"content\": [
        """ + GRADUATION_RESPONSE_EXAMPLE + """
      ]
    }
  """;
}
