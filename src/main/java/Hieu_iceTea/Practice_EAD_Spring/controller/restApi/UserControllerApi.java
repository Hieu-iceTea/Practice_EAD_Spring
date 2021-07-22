package Hieu_iceTea.Practice_EAD_Spring.controller.restApi;


import Hieu_iceTea.Practice_EAD_Spring.model.User;
import Hieu_iceTea.Practice_EAD_Spring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/restApi/users")
public class UserControllerApi {

    //TODO: Sửa lỗi vòng lặp đệ quy khi xử lý JSON, lý do relationship giữa các bảng.
    //Video hướng dẫn của cô ThiDK: http://youtube.com/watch?v=pMxgLOPe_OE

    //region - Autowired Service -
    @Autowired
    private UserService userService;
    //endregion


    //region - Display -
    @GetMapping(path = {"", "/", "/index"})
    public List<User> index(@RequestParam(required = false) String search) {

        return userService.getAll(search);

    }

    @GetMapping(path = {"/{id}/", "/{id}"})
    public User show(@PathVariable int id) {

        return userService.findById(id);

    }
    //endregion
}
