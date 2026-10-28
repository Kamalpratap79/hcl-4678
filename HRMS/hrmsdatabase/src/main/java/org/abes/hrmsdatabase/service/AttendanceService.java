package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.AttendanceRepository;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public String markAttendance(Attendance attendance) {
        if (attendance.getEmployee() == null) {
            return "Attendance not marked: Employee information missing";
        }

        long empId = attendance.getEmployee().getEmpid();

        if (employeeRepository.existsById(empId)) {
            boolean alreadyMarked = attendanceRepository.
                    existsByEmployee_EmpidAndAttendancedate(empId, LocalDate.now());

            if (!alreadyMarked) {
                attendance.setAttendancedate(LocalDate.now());
                attendanceRepository.save(attendance);
                return "Attendance Marked Successfully";
            } else {
                return "Attendance already marked for today";
            }
        } else {
            return "Attendance not marked: Employee does not exist";
        }
    }


    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> getAttendanceByEmployeeId(Long empid) {
        return attendanceRepository
                .findByEmployee_EmpidOrderByAttendancedateDesc(empid);
    }
}
