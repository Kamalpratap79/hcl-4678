package org.abes.hrmsdatabase.repository;

import org.abes.hrmsdatabase.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Correct Spring keyword is "existsBy", followed by your property names
    boolean existsByEmployee_EmpidAndAttendancedate(Long empid, LocalDate date);
}
