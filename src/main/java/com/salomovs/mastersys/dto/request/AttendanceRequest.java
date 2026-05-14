package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Future;

import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.Attendance;
import com.salomovs.mastersys.domain.Registration;

public record AttendanceRequest (
  @NotNull(message="AttendanceStartDate field missing")
  @FutureOrPresent(message="Past date is not allowed")
  LocalDateTime attendanceStartDate,

  @NotNull(message="AttendanceStartDate field missing")
  @Future(message="Only future dates are allowed")
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
