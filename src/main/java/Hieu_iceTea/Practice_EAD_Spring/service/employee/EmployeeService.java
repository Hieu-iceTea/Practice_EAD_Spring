package Hieu_iceTea.Practice_EAD_Spring.service.employee;


import Hieu_iceTea.Practice_EAD_Spring.model.Employee;
import Hieu_iceTea.Practice_EAD_Spring.service.base.BaseService;

import java.util.List;


public interface EmployeeService extends BaseService<Employee, Integer> {

    List<Employee> getAll(String KeywordSearch);

}
