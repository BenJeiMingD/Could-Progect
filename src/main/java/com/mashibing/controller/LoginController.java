package com.mashibing.controller;

import com.mashibing.bean.TblUserRecord;
import com.mashibing.result.Permission;
import com.mashibing.result.Permissions;
import com.mashibing.result.R;
import com.mashibing.result.UserInfo;
import com.mashibing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    // 解决前端报错
    @RequestMapping("/auth/2step-code")
    public boolean step_code2(){
        System.out.println("此请求是前端框架带的默认请求，可以不做任何处理，也可以在前端将其删除");
        System.out.println("step_code2");
        return true;
    }
    @RequestMapping("/auth/login")
    public R login(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password,
                               HttpSession session){
        TblUserRecord tblUserRecord = loginService.login(username, password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        session.setAttribute("userRecord",tblUserRecord);
        R result = new R(200,"ok",tblUserRecord);
        System.out.println(result);
        return result;
    }
    @RequestMapping("/user/info")
    public  R getInfo(HttpSession session){
        //获取用户信息
        TblUserRecord userRecord = (TblUserRecord)session.getAttribute("userRecord");
        //获取用户信息对应的角色名称
        String[] rolePrivileges = userRecord.getTblRole().getRolePrivileges().split("-");
        //拼接需要返回的数据对象格式
        Permissions permissions = new Permissions();
        List<Permission> permissionlist = new ArrayList<>();
        for (String rolePrivilege : rolePrivileges) {
            //把id放到list中
            permissionlist.add(new Permission(rolePrivilege));
        }
        permissions.setPermissions(permissionlist);
        //把list和username放到unerinfo中
        UserInfo userInfo = new UserInfo(userRecord.getUserName(),permissions);
        return new R(userInfo);
    }
    //当退出时关闭session域
    @RequestMapping("/auth/logout")
    public void logout(HttpSession session){
        session.invalidate();
        System.out.println("logout");
    }
}
