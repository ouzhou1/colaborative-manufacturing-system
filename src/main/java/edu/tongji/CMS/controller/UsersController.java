package edu.tongji.CMS.controller;

import edu.tongji.CMS.dao.partners.*;
import edu.tongji.CMS.domain.Users.*;
import edu.tongji.CMS.domain.vo.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.CMS.dao.users.UsersDao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PartnersDao partnersDao;

    @Autowired
    private UserOrderBindingDao userOrderBindingDao;

    @Autowired
    private EvaluationDao evaluationDao;

    @Autowired
    private TimeEvaluationDao timeEvaluationDao;

    @Autowired
    private QualityEvaluationDao qualityEvaluationDao;

    @Autowired
    private AbilityEvaluationDao abilityEvaluationDao;

    @Autowired
    private ServiceEvaluationDao serviceEvaluationDao;

    @GetMapping(value = "")
    public String usersList(Model model) {
        model.addAttribute("users", usersDao.findAll());
        model.addAttribute("users_count", usersDao.count());
        model.addAttribute("personal_users", usersDao.findByUserCategory("personal"));
        model.addAttribute("enterprise_users", usersDao.findByUserCategory("enterprise"));
        return "users/dashboard";
    }

    @GetMapping("/{id}")
    public Users userData(@PathVariable("id") long id) {
        return usersDao.findOne(id);
    }

    @GetMapping("/details/{id}")
    public ModelAndView viewPersonInfo(@PathVariable("id") long id) {
        Users user = usersDao.findOne(id);
        return new ModelAndView("users/details", "user", user);
    }

    @GetMapping("/profile/{id}")
    public ModelAndView viewUserProfile(@PathVariable("id") long id) {
        Users user = usersDao.findOne(id);
        return new ModelAndView("users/profile", "user", user);
    }

    @GetMapping("/{orderid}/binding")
    public ModelAndView activeUsers(@PathVariable Long orderid) {
        List<Users> activeUsers = usersDao.findByStatus("ACTIVE");
        ModelAndView modelAndView = new ModelAndView("users/binding", "activeusers", activeUsers);
        modelAndView.addObject("orderid", orderid);
        return modelAndView;
    }

    @RequestMapping(value = "/request/binding/{userid}/{orderid}", method = RequestMethod.POST)
    public ModelAndView userOrderBinding(@PathVariable("userid") long userid, @PathVariable("orderid") long orderId) {
        UserOrderBinding userOrderBinding = new UserOrderBinding();
        userOrderBinding.setOrderId(orderId);
        userOrderBinding.setUserId(userid);
        userOrderBinding.setStatus("ACTIVE");
        userOrderBindingDao.save(userOrderBinding);

        // Create partner in order
        Users user = usersDao.findOne(userid);
        Partner partner = new Partner();
        partner.setCreateTime(new Date());
        partner.setUserId(userid);
        partner.setUserName(user.getUsername());
        partner.setStatus("NEW");
        partnersDao.save(partner);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/evaluation/{userid}")
    public ModelAndView userEvaluationResult(@PathVariable("userid") long userid) {
        List<Evaluation> evaluations = evaluationDao.findByUserId(userid);
        Evaluation evaluation = null;
        if (evaluations != null && !evaluations.isEmpty()) {
            evaluation = evaluations.get(0);
        }
        TimeEvaluation timeEvaluation = timeEvaluationDao.findByUserId(userid).get(0);
        AbilityEvaluation abilityEvaluation = abilityEvaluationDao.findByUserId(userid).get(0);
        QualityEvaluation qualityEvaluation = qualityEvaluationDao.findByUserId(userid).get(0);
        ServiceEvaluation serviceEvaluation = serviceEvaluationDao.findByUserId(userid).get(0);
        ModelAndView modelAndView = new ModelAndView("users/evaluation");
        modelAndView.addObject("evaluation", evaluation);
        modelAndView.addObject("timeEvaluation", timeEvaluation);
        modelAndView.addObject("abilityEvaluation", abilityEvaluation);
        modelAndView.addObject("qualityEvaluation", qualityEvaluation);
        modelAndView.addObject("serviceEvaluation", serviceEvaluation);
        return modelAndView;
    }

    @GetMapping("/evaluation/form")
    public ModelAndView userEvaluationForm(@ModelAttribute Evaluation evaluation) {
        ModelAndView modelAndView = new ModelAndView("users/evaluationform");
        modelAndView.addObject("evaluation", evaluation);
        return modelAndView;
    }

    @GetMapping("/publish")
    public ModelAndView publishUser(@ModelAttribute Users users) {
        return new ModelAndView("users/publish");
    }

    @GetMapping("/modify/{id}")
    public ModelAndView usersModifyForm(@ModelAttribute Users users) {
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
                                        String user_category, String status) {
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
