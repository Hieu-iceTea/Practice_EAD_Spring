package Hieu_iceTea.Practice_EAD_Spring.service.user;


import Hieu_iceTea.Practice_EAD_Spring.model.User;
import Hieu_iceTea.Practice_EAD_Spring.service.base.BaseService;

import java.util.List;


public interface UserService extends BaseService<User, Integer> {

    User findByUsername(String username);

    User getCurrentUser();

    List<User> getAll(String KeywordSearch);

}
