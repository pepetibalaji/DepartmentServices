package department.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import department.services.entity.Department;

@Controller
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
