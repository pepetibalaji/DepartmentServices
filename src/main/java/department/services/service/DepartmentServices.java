package department.services.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import department.services.DepartmentDto.DepartmentForm;
import department.services.entity.Department;
import department.services.entity.Department.DepartmentBuilder;
import department.services.globalExceptions.DepartmentNotFound;
import department.services.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServices {

    public final DepartmentRepository departmentRepository;

    @Transactional
    public Department saveDepartment(DepartmentForm entity) {
        DepartmentBuilder dept = Department.builder()
                .name(entity.getName())
                .location(entity.getLocation());
        return departmentRepository.save(dept.build());
    }

    public Department getDepartment(long long1) throws DepartmentNotFound {
        Optional<Department> dept = departmentRepository.findById(long1);
        if (dept.isPresent()) {
            return dept.get();
        }
        throw new DepartmentNotFound("Department not found");
    }

}
