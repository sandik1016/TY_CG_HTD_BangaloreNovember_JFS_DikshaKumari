package com.capgemini.springmvc.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.springmvc.beans.User;

@Controller
public class SpringController {
	
	@Autowired
	private ServletContext context;//autowired it to class level
	
	
	
	
	@RequestMapping("/hello")//bydefault it will map to path only
	public String hello(ModelMap map) {
		map.addAttribute("msg","Hello World.......!!!");
		return "index";//return name of the jsp file...dspatcher servlet doesnt knw abut it it will request view resolver it will return exact path of jsp 
	}

	//or	@RequestMapping(path="/query",method = RequestMethod.GET)//handler method//equivalnt like doget()
	@GetMapping("/query")
	public String query(@RequestParam(name="name")String name,@RequestParam("age")int age,ModelMap map) {//automatically convert to required datatype
		//for class type it will display null

		//public String query(@RequestParam(name="name",required =false,defaultValue = "Siri")String name,@RequestParam("age")Integer age,ModelMap map) 
		map.addAttribute("name",name);
		map.addAttribute("age",age);


		return "query";
	}//querystring 

	@GetMapping("/form")
	public String form() {
		return "form";

	}
	@PostMapping("/form")
	//it automatically map all field that is variable
	public String form(User user,ModelMap map) {
		//or public String form(String name,String email,String password,String gender,ModelMap map) {//same as input field of html
		//		map.addAttribute("name",name);
		//		map.addAttribute("email",email);
		//		map.addAttribute("password",password);
		//		map.addAttribute("gender",gender);
		map.addAttribute("name",user.getName());
		map.addAttribute("email",user.getEmail());
		map.addAttribute("password",user.getPassword());
		map.addAttribute("gender",user.getGender());
		return "form";
	}

	//cookie
	@GetMapping("/createcookie")//it will work without /
	public String createCookie(HttpServletResponse res) {

		Cookie cookie = new Cookie("name","Diksha");
		res.addCookie(cookie);//cookie will go to browser via res
		return "createcookie";
	}
	@GetMapping("/getcookie")
	public String getCookie(@CookieValue(name="name",required = false)String name ,ModelMap map) {//it will give value of cookie object...we dont have to check this cookie has particular value by for loop

		if(name != null)
			map.addAttribute("name",name);
		else

			map.addAttribute("name","defaultnameofcookie");
		return "getcookie";
	}

	//path param.........//for a server it is just a path
	@GetMapping("/path/{movie}/{hero}")
	public String path(@PathVariable("movie")String movie,@PathVariable ("hero")String hero,ModelMap map) {//spring doesnt knw u r rq for path param so specify 

		//pass to front end using addattribute
		map.addAttribute("movie",movie);
		map.addAttribute("hero",hero);
		return "pathvalue";//jsp name as pathvalue
	}

	//forward

	@GetMapping("/forward")//bydefault we are forwarding req to jsp here we are forwarding to another controller
	public String forward() {
		return "forward:form";//controller name not jsp name
	}


	//redirect
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:hello";//  or return "redirect:http://www.google.com";
	}






	//session

	@GetMapping("/loginSession")
	//go to the form first then we donot hit directly jsp
	public String login() {
		return "loginSession";
	}




	@PostMapping("/loginSession")//more valid and efficient
	public String login(String username,String password,HttpServletRequest request,ModelMap map) {
		if(username.equals("user")&& password.equals("qwerty")) {
			User user = new User();
			user.setName(username);
			user.setEmail("user@gmail.com");
			user.setPassword(password);
			user.setGender("F");
			HttpSession session = request.getSession();//create session
			session.setAttribute("user", user);//setting the session attribute
			map.addAttribute("msg","user logged in");
			return "home";
		}
		else {
			map.addAttribute("msg","invalid credential");
			return"loginSession";
		}
	}

	//validate session
	@GetMapping("home")
	public String home(@SessionAttribute (name = "user",required = false) User user) {//when we click on home page directly then if user is logged in go to home itself othrwise loginpage because session is not existing 
		//get the session attribute
		if(user!=null)
			return "home";
		else
			return "loginSession";

		//to invalidate session -session.invalidate();
	}

	@GetMapping("setappattribute")
	public String setAppAttribute(){
		//accept object type
		context.setAttribute("msg", new Object());
		return "setcontext";

	}

	@GetMapping("getappattribute")
	public String getAppAttribute() {
		System.out.println(context.getAttribute("msg"));
		return "getcontext";

	}
}

