package Hieu_iceTea.Practice_EAD_Spring.repository;


import Hieu_iceTea.Practice_EAD_Spring.model.Employee;

import java.util.List;


public interface EmployeeRepository extends BaseRepository<Employee, Integer> {

    List<Employee> findAllByNameContainsOrderByIdDesc(String name);

}