package org.abes.hrmsdatabase.repository;

import org.abes.hrmsdatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    boolean existsByPasswordAndEmpid(String password,long id);

    //boolean existByEmail(String email);
}
