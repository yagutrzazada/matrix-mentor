package org.example.matrixmentor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    //@Override
  //  List<EmployeeEntity> findAll();
}
