package Hieu_iceTea.Practice_EAD_Spring.service.employee;


import Hieu_iceTea.Practice_EAD_Spring.model.Employee;
import Hieu_iceTea.Practice_EAD_Spring.repository.BaseRepository;
import Hieu_iceTea.Practice_EAD_Spring.repository.EmployeeRepository;
import Hieu_iceTea.Practice_EAD_Spring.service.base.BaseServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImplement extends BaseServiceImplement<Employee, Integer> implements EmployeeService {

    //region Initialization - Autowired
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplement(EmployeeRepository repository) {
        super(repository);
    }
    //endregion


    //region Method
    @Override
    public List<Employee> getAll(String KeywordSearch) {
        List<Employee> products;
        if (KeywordSearch == null) {
            products = employeeRepository.findAllByOrderByIdDesc();
        } else {
            products = employeeRepository.findAllByNameContainsOrderByIdDesc(KeywordSearch);
        }

        return products;
    }
    //endregion

}
