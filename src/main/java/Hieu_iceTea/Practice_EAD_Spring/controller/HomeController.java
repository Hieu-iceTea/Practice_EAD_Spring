package Hieu_iceTea.Practice_EAD_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    //region - Autowired Service -
    /*@Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private RestaurantService restaurantService;*/
    //endregion


    //region - Display -
    /*@GetMapping(path = {"", "/", "/index"})
    public String index(Model model) {

        List<ProductCategory> productCategories = productCategoryService.findAll();
        model.addAttribute("productCategories", productCategories);

        List<Restaurant> restaurants = restaurantService.findAll();
        model.addAttribute("restaurants", restaurants);

        return "front/index";
    }*/
    //endregion


    //region - Static pages -
    @GetMapping(path = {"/contact", "/contact/"})
    public String contact() {

        return "front/contact";
    }

    @GetMapping(path = {"/about", "/about/"})
    public String about() {

        return "front/about";
    }
    //endregion

}
