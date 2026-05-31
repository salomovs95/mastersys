package com.salomovs.mastersys.doc.example;

public interface RegistrationExample {

  static final String REG_MODALITY_REQUEST_EXAMPLE = """
    {
      \"startDate\":\"...\",
      \"finishDate\":\"...\"
    }
  """;

  static final String REGISTRATION_REQUEST_EXAMPLE = """
    {
      \"registrationDate\":\"...\",
      \"closingDate\":\"...\",
      \"dueDay\":\"...\",
      \"registrationModality\":""" + REG_MODALITY_REQUEST_EXAMPLE + """
    }
  """;

  static final String REGISTRATION_RESPONSE_EXAMPLE = """
    {
      \"id\":999,
      \"registrationDate\":\"...\",
      \"closingDate\":\"...\",
      \"dueDay\":\"...\",
      \"status\":\"...\",
      \"student\":""" + StudentExample.STUDENT_RESPONSE_EXAMPLE + """
    }
  """;

  static final String REG_MODALITY_RESPONSE_EXAMPLE = """
    {
      \"id\":999,
      \"registration\":""" + REGISTRATION_RESPONSE_EXAMPLE + "," + """
      \"modality\":""" + ModalityExample.MODALITY_RESPONSE_EXAMPLE + "," + """
      \"graduation\":""" + GraduationExample.GRADUATION_RESPONSE_EXAMPLE + "," + """
      \"plan\":""" + PlanExample.PLAN_RESPONSE_EXAMPLE + "," + """
      \"startDate\":\"...\",
      \"finishDate\":\"...\"
    }
  """;

  static final String PAGE_RESPONSE_EXAMPLE = """
    {
      \"page\":0,
      \"content\":[
        """ + REG_MODALITY_RESPONSE_EXAMPLE + """
      ]
    }
  """;
  
}
