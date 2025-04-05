package org.example.matrixmentor.service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.matrixmentor.dao.EmployeeEntity;
import org.example.matrixmentor.dao.EmployeeRepository;
import org.example.matrixmentor.enums.ErrorMessage;
import org.example.matrixmentor.exception.NotFoundException;
import org.example.matrixmentor.mapper.EmployeeMapper;
import org.example.matrixmentor.model.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    // private final EmployeeMapper employeeMapper;

    public void createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity entity = EmployeeMapper.Instance.toEmployeeEntity(employeeDto);
        employeeRepository.save(entity);
    }
//errormessage islet
    public EmployeeDto findEmployeeById(Long id) {
        var employeeEntity = employeeRepository.findById(id).orElseThrow(() ->  new NotFoundException("cant find id "));
        return EmployeeMapper.Instance.toEmployeeDto(employeeEntity);
    }

    public List<EmployeeDto> findEmployees() {
        List<EmployeeDto> employees = employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper.Instance::toEmployeeDto)
                .toList();
        return employees;
    }

    public void updateEmployee(Long id, EmployeeDto dto) {
        EmployeeEntity entity = employeeRepository.findById(id).orElseThrow(() ->
                //id elave et
                new RuntimeException(String.format(ErrorMessage.EMPLOYEE_NOT_FOUND.getMessage(),id)));
        EmployeeMapper.Instance.toEmployeeDto(entity);
        employeeRepository.save(entity);
    }

    public void deleteEmployee(Long id) {
            employeeRepository.deleteById(id);
    }
}




