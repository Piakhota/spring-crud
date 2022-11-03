package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAll(ModelMap model) {
        List<User> allUsers = userService.getAll();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNew(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/updateInfo")
    public String update(@RequestParam("id") Long id, ModelMap model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/deleteUser")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
