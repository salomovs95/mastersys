package com.salomovs.mastersys.dto.request;

import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.Attendance;
import com.salomovs.mastersys.domain.Registration;

public record AttendanceRequest (
  LocalDateTime attendanceStartDate,
  LocalDateTime attendanceEndDate
) {
  public Attendance toEntity(Registration registration) {
    Attendance attendance = new Attendance();
    attendance.setRegistration(registration);
    fillUp(attendance);
    return attendance;
  }

  public void fillUp(Attendance attendance) {
    if (attendanceStartDate != null)
      attendance.setAttendanceStartDate(attendanceStartDate);

    if (attendanceEndDate != null)
      attendance.setAttendanceEndDate(attendanceEndDate);
  }
}
