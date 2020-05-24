package com.cloud.justyou.controller.fore;

import com.cloud.justyou.controller.util_controller.BaseController;
import com.cloud.justyou.model.BigSorts;
import com.cloud.justyou.model.SmallSorts;
import com.cloud.justyou.model.Task;
import com.cloud.justyou.model.Users;
import com.cloud.justyou.service.BigSortsService;
import com.cloud.justyou.service.IndexService;
import com.cloud.justyou.service.SmallSortsService;
import com.cloud.justyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private BigSortsService bigSortsService;

    @Autowired
    private SmallSortsService smallSortsService;

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user_name 用户名
     * @param user_user_password 用户密码
     * @param model 登录失败时，返回给前端显示的数据msg
     * @param session 用户与服务器通讯
     * @return 跳转页面
     */
    @PostMapping("user/login")
    public String login(@RequestParam("user_name") String user_name,
                        @RequestParam("user_password") String user_user_password,
                        Model model, HttpSession session)
    {
        Users users = userService.login(user_name, user_user_password);
        if(users != null){
            session.setAttribute("loginUser",user_name);
            session.setAttribute("user_Id", users.getUser_id());
            System.out.println(users);

            //跳转到网站首页
            return "";
//            return "redirect:/main.html";
        }
        else {
            System.out.println(users);
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }

    }


    /**
     * 注销账户
     *
     * @param session 用户与服务器通讯
     * @return 重定向到登录页面
     */
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        //将session设置为失效
        session.invalidate();

        return "redirect:/index.html";
    }


    /**
     * 注册
     *
     * @param user_id 用户id
     * @param user_name 用户名
     * @param user_password 用户密码
     * @param user_email 用户邮箱
     * @param user_birthday 用户生日
     * @param user_telephone_number 用户电话
     * @param user_nickname 用户昵称
     * @return 人脸注册页面
     */
    @PostMapping("/addUser")
    public String addUser(@RequestParam("user_id")long user_id,
                          @RequestParam("user_name")String user_name,
                          @RequestParam("user_password")String user_password,
                          @RequestParam("user_email")String user_email,
                          @RequestParam("user_birthday") Date user_birthday,
                          @RequestParam("user_telephone_number")String user_telephone_number,
                          @RequestParam("user_nickname")String user_nickname){
        userService.register(user_id,user_password,user_name,user_email,user_birthday,user_telephone_number,user_nickname);

        return "";
    }

    /**
     * @return 跳转到登录页面
     */
    @GetMapping("/toLoginPage")
    public String toLoginPage(){

        //跳转到登录页面
        return "";
    }

    /**
     * @return 跳转到注册页面
     */
    @GetMapping("/toRegisterPage")
    public String toRegisterPage(){

        //跳转到注册页面
        return "";
    }

    /**
     * 前端点击登录后发送此请求
     *
     * @return 主页页面
     */
    @RequestMapping("/loginAction")
    public String toHomepage(){
        //跳转主页页面
        return "";
    }

    @RequestMapping("/HomePage")
    public String HomePage(Model model){

        //运动，学习
        Collection<BigSorts> bigSorts = bigSortsService.getBigSorts();

        model.addAttribute("bigSorts",bigSorts);

        //篮球，数学
        Collection<SmallSorts> smallSorts = smallSortsService.getSmallSorts();

        model.addAttribute("smallSorts",smallSorts);

        //发布的请求
        Collection<Task> tasks = indexService.getTaskInfo();

        model.addAttribute("tasks",tasks);

        //跳转至首页页面
        return "";
    }

    @GetMapping("/toDetailsPage/{task_id}")
    public String toDetailsPage(@PathVariable("task_id")Integer task_id, Model model
                                ,HttpSession session){
        Object user_id = BaseController.checkUser(session);

        if(user_id != null){
            //用户已登陆

        }else {
            //用户未登录
            return "redirect:/login";
        }


        Collection<Task> tasks = indexService.getAll(task_id) ;

        model.addAttribute("tasks",tasks);

        //跳转至请求详情页
        return "";
    }

    @RequestMapping("/toSortsPage/{sort_name}")
    public String toSortsPage(@PathVariable("sort_name")String sort_name,Model model,
                              HttpSession session){
        Object user_id = BaseController.checkUser(session);

        if(user_id != null){
            //用户已登陆

        }else {
            //用户未登录
            return "redirect:/login";
        }

        //运动，学习
        Collection<BigSorts> bigSorts = bigSortsService.getBigSortsByName(sort_name);

        model.addAttribute("bigSorts",bigSorts);

        //篮球，数学
        Collection<SmallSorts> smallSorts = smallSortsService.getSmallSorts();

        model.addAttribute("smallSorts",smallSorts);

        //跳转至分类好的页面
        return "";

    }

    @RequestMapping("/toPersonalDetails/")
    public String toPersonalDetails(HttpSession session){
        Object user_id = BaseController.checkUser(session);

        if(user_id != null){
            //用户已登陆

        }else {
            //用户未登录
            return "redirect:/login";
        }



        //跳转个人主页
        return "";
    }


}
