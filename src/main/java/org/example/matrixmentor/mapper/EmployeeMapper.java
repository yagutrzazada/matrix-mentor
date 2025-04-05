package org.example.matrixmentor.mapper;


import org.example.matrixmentor.dao.EmployeeEntity;
import org.example.matrixmentor.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()//componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper Instance= Mappers.getMapper(EmployeeMapper.class);
    EmployeeEntity toEmployeeEntity(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(EmployeeEntity employeeEntity);

}
