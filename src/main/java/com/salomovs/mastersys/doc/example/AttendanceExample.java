package com.salomovs.mastersys.doc.example;

public interface AttendanceExample {

  static final String ATTENDANCE_REQUEST_EXAMPLE = """
    {
      \"attendanceStartDate,\":\"...\",
      \"attendanceEndDate,\":\"...\",
    }
  """;

  static final String ATTENDANCE_RESPONSE_EXAMPLE = """
    {
      \"id\": 999,
      \"attendanceStartDate\":\"...\",
      \"attendanceEndDate\":\"...\",
      \"registration\":{
        \"id\": 998,
        \"registrationDate\":\"...\",
        \"closingDate\":\"...\",
        \"dueDay\":\"...\",
        \"status\":\"...\",
        \"student\":{\"...\"},
      }
    }
  """;

  static final String PAGE_RESPONSE_EXAMPLE = """
    {
      \"page\":0,
      \"content\":[
        """ + ATTENDANCE_RESPONSE_EXAMPLE + """
      ]
    }
  """;
}
