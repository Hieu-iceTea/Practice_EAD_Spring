package Hieu_iceTea.Practice_EAD_Spring.controller.restApi;


import Hieu_iceTea.Practice_EAD_Spring.model.User;
import Hieu_iceTea.Practice_EAD_Spring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    //region - Create -
    @PostMapping(path = {"/create/", "/create"})
    public User store(@ModelAttribute User user) {

        User newUser = userService.save(user);

        return userService.findById(newUser.getId());

    }
    //endregion


    //region - Edit -
    @PostMapping(path = {"/{id}/edit/", "/{id}/edit"})
    public User update(@ModelAttribute User user,
                         BindingResult bindingResult,
                         @RequestParam("image_file") MultipartFile file,
                         @RequestParam("image_old") String fileName_old,
                         @RequestParam(value = "arrAuthorities[]", required = false) String[] arrAuthorities) {

        //Xử lý Form-Validation
        /*if (bindingResult.hasErrors()) {
            return "dashboard/user/create-edit";
        }*/

        //Xử lý file
        /*if (!file.isEmpty()) {
            // 01. Xóa file cũ:
            if (fileName_old != null && !fileName_old.isBlank()) {
                storageService.delete(fileName_old, _imagePath);
            }

            // 02. Lưu file mới:
            String fileName =  storageService.store(file, _imagePath);
            user.setImage(fileName);
        }*/

        //Xử lý mật khẩu:
        String password = user.getPassword();
        if (password != null && !password.isBlank()) {
            String passwordEncode = new BCryptPasswordEncoder().encode(password); //mã hóa mật khẩu kiểu 'BCrypt'

            user.setPassword("{bcrypt}" + passwordEncode);
        } else {
            user.setPassword(userService.findById(user.getId()).getPassword()); //Giữ nguyên mật khẩu hiện tại
        }

        //Gọi đến service, lưu vào database
        //authorityService.updateUserAuthority(userService.findById(user.getId()), arrAuthorities);
        userService.save(user);

        return userService.findById(user.getId());
    }
    //endregion


    //region - Delete -
    @DeleteMapping(path = {"/{id}/", "/{id}"})
    public List<User> delete(@PathVariable int id) {

        // 01. Xóa file:
        /*String fileName_old = userService.findById(id).getImage();
        if (fileName_old != null && !fileName_old.isBlank()) {
            storageService.delete(fileName_old, _imagePath);
        }*/

        // 02. Xóa bản ghi database
        userService.deleteById(id);

        return userService.findAll();

    }
    //endregion

}
