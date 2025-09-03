package department.services.controller;

import org.springframework.web.bind.annotation.RestController;

import department.services.DepartmentDto.DepartmentForm;
import department.services.entity.Department;
import department.services.globalExceptions.DepartmentNotFound;
import department.services.service.DepartmentServices;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    public final DepartmentServices departmentServices;

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody DepartmentForm entity) {
        return departmentServices.saveDepartment(entity);
    }

    @GetMapping("/getDepartment")
    public Department getDepartment(@RequestParam Long dept_id) throws DepartmentNotFound {
        return departmentServices.getDepartment(dept_id);
    }
}
