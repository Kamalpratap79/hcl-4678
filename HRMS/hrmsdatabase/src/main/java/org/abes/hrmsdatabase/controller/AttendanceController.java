package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.AttendanceService;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("v1/user/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/markattendance")
    public String markAttendance(@RequestBody Attendance attendance){
        return attendanceService.markAttendance(attendance);
    }

    @GetMapping("/getattendance")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/employee/{empid}")
    public List<Attendance> getAttendanceByEmployee(
            @PathVariable Long empid) {

        return attendanceService.getAttendanceByEmployeeId(empid);
    }

}
