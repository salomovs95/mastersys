package com.salomovs.mastersys.doc.example;

public interface StudentExample {

  static final String ADDRESS_EXAMPLE = """
    {
      \"address\":\"...\",
      \"number\":\"...\",
      \"neighborhood\":\"...\",
      \"complement\":\"...\",
      \"city\":\"...\",
      \"federalUnity\":\"...\",
      \"zipCode\":\"...\"
    }
  """;

  static final String CONTACT_EXAMPLE = """
    {
      \"email\":\"...\",
      \"mainPhoneNumber\":\"...\",
      \"secondPhoneNumber\":\"...\"
    }
  """;

  static final String STUDENT_REQUEST_EXAMPLE = """
    {
      \"name\":\"REPLACE '...' WITH ACTUAL DATA :D\",
      \"taxId\":\"...\",
      \"birthdate\":\"...\",
      \"gender\":\"...\",
      \"contact\":""" + CONTACT_EXAMPLE + "," + """
      \"address\":""" + ADDRESS_EXAMPLE + "," + """
    }
  """;

  static final String STUDENT_RESPONSE_EXAMPLE = """
    {
      \"id\":999,
      \"name\":\"REPLACE '...' WITH ACTUAL DATA :D\",
      \"taxId\":\"...\",
      \"birthdate\":\"...\",
      \"gender\":\"...\",
      \"contact\":""" + CONTACT_EXAMPLE + "," + """
      \"address\":""" + ADDRESS_EXAMPLE + "," + """
    }
  """;

  static final String PAGE_RESPONSE_EXAMPLE = """
    \"page\":0,
    \"content\":[
      """ + STUDENT_RESPONSE_EXAMPLE + """
    ]
  """;

}
