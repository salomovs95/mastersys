package com.salomovs.mastersys.dto.response;

import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.Attendance;

public record AttendanceResponse (
  Long id,
  LocalDateTime attendanceStartDate,
  LocalDateTime attendanceEndDate,
  RegistrationResponse registration
) {
  public static AttendanceResponse fromEntity(Attendance attendance) {
    return new AttendanceResponse(
      attendance.getId(),
      attendance.getAttendanceStartDate(),
      attendance.getAttendanceEndDate(),
      RegistrationResponse.fromEntity(attendance.getRegistration())
    );
  }
}
