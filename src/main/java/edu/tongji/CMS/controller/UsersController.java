package edu.tongji.CMS.controller;

import edu.tongji.CMS.domain.vo.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.CMS.dao.users.UsersDao;
import edu.tongji.CMS.domain.Services;
import edu.tongji.CMS.domain.Users;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @GetMapping(value = "")
    public String usersList(Model model) {
        model.addAttribute("users", usersDao.findAll());
        model.addAttribute("users_count", usersDao.count());
        model.addAttribute("personal_users", usersDao.findByUserCategory("personal"));
        model.addAttribute("enterprise_users", usersDao.findByUserCategory("enterprise"));
        return "users/dashboard";
    }

    @GetMapping("/{id}")
    public ModelAndView viewPersonInfo(@PathVariable("id") long id) {
        Users user = usersDao.findOne(id);
        return new ModelAndView("users/details", "user", user);
    }

    @GetMapping("/publish")
    public ModelAndView publishUser(@ModelAttribute Users users) {
        return new ModelAndView("users/publish");
    }

    @GetMapping("/modify/{id}")
    public ModelAndView serviceCreateForm(@ModelAttribute Services services) {
        return new ModelAndView("users/modify");
    }

    private Map<String, Object> resultinfo = new HashMap<>();

    @PostMapping("/loginUser")
    public Map<String, Object> userLogin(String username, String password) {

        resultinfo.clear();
        Users user = usersDao.findByUsername(username);
        if (user == null) {
            resultinfo.put("success", false);
            resultinfo.put("message", "用户名未注册！");
        } else {
            if (password.equals(user.getPassword())) {
                resultinfo.put("success", true);
                resultinfo.put("message", "index.html");
                resultinfo.put("username", user.getUsername());
            } else {
                resultinfo.put("success", false);
                resultinfo.put("message", "用户名或者密码错误！");
            }
        }
        return resultinfo;
    }

    @GetMapping("/delUser/{id}")
    public Map<String, Object> userDel(@PathVariable(value = "id") Long id) {
        resultinfo.clear();
        usersDao.delete(id);
        resultinfo.put("success", true);
        resultinfo.put("message", "用户删除成功！");
        return resultinfo;
    }

    @GetMapping("/saveUser")
    public Map<String, Object> userSave(Long id, String username, String password,
                                        String user_category, UserStatus status) {
        resultinfo.clear();
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setUser_category(user_category);
        user.setStatus(status);
        if (id == null)
            usersDao.save(user);
        else {
            user.setId(id);
            usersDao.save(user);
        }
        resultinfo.put("success", true);
        resultinfo.put("message", "用户添加成功！");
        return resultinfo;
    }

    @GetMapping("/loadUser/{id}")
    public Map<String, Object> loadUser(@PathVariable("id") long id) {
        resultinfo.clear();
        Users user = usersDao.findOne(id);
        resultinfo.put("user_id", user.getId());
        resultinfo.put("user_accont", user.getPassword());
        resultinfo.put("user_name", user.getUsername());
        resultinfo.put("user_password", user.getPassword());
        resultinfo.put("user_role", user.getUser_category());
        resultinfo.put("user_status", user.getStatus());
        return resultinfo;
    }

    @GetMapping(value = "/notification")
    public String userCommunication() {
        return "users/notification";
    }
}
