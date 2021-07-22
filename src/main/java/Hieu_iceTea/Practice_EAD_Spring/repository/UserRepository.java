package Hieu_iceTea.Practice_EAD_Spring.repository;


import Hieu_iceTea.Practice_EAD_Spring.model.User;

import java.util.List;


public interface UserRepository extends BaseRepository<User, Integer> {

    User findByUsername(String username);

    List<User> findAllByNameContainsOrderByIdDesc(String name);

}