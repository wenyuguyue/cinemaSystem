package com.icss.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.icss.biz.UserBiz;
import com.icss.entity.User;
import com.icss.util.Log;

@Controller
public class UserAction {
@Autowired
UserBiz userBiz;

	@RequestMapping("/login")
	@ResponseBody
	public User login(User user,HttpSession session,HttpServletResponse resp) {
		String name=user.getName();
		String pwd=user.getPwd();
		try {
			User user2=userBiz.login(name,pwd);
			if(user2!=null && user2.getName()!=null) {
				session.setAttribute("user", user2);	
				Cookie cookie_name=new Cookie("name", user.getName());
				resp.addCookie(cookie_name);
			}		
			return user2;
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return null;
		}
	}
	
	@RequestMapping("checkName")
	@ResponseBody
	public String checkName(String name) {
		try {
			boolean isValid = userBiz.isValid(name);
			if (isValid) {
				return "{\"code\":\"400\",\"msg\":\"校验失败\"}";
			} else {
				return "{\"code\":\"200\",\"msg\":\"校验通过\"}";
			}
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return "{\"code\":\"500\",\"msg\":\"系统错误\"}";
		}
	}
	
	@RequestMapping("regist")
	public String regist(User user) {
		try {
			if( userBiz.regist(user)==1) {
				return "login.html";
			}else {
				return "regist.html";
			}
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return "error-500.html";
		}
	}
	
	/**
     * 上传文件
     * @param request
     * @param response
     * @param file 上传的文件，支持多文件
     * @throws Exception
     */
    @RequestMapping("/changePic")
    @ResponseBody
    public Object insert(HttpServletRequest request,HttpServletResponse response
            ,@RequestParam("file") MultipartFile[] file) throws Exception{
		System.out.println("***************************");		
    	return file;
       
    }
}
