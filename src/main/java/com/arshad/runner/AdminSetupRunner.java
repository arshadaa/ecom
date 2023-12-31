package com.arshad.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.arshad.constants.UserRole;
import com.arshad.entity.User;
import com.arshad.repo.UserRepository;
import com.arshad.util.AppUtil;
import com.arshad.util.MyMailUtil;

@Component
public class AdminSetupRunner implements CommandLineRunner {

	@Value("${app.admin.email}")
	private String username;

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MyMailUtil mailUtil;

	@Override
	public void run(String... args) throws Exception {
		
		if(!repository.findByEmail(username).isPresent()) {
			String pwd = AppUtil.genPwd();
			
			User user = new User();
			user.setDisplayName("SELLER");
			user.setEmail(username);
			user.setPassword(encoder.encode(pwd));
			user.setRole(UserRole.SELLER);
			user.setStatus("ACTIVE");
			user.setAddress("NONE");
			user.setContact("999999999");
			
			
			Long id  = repository.save(user).getId();
			
			if(id!=null) { //only on user register (send email as a thread)
				new Thread(new Runnable() {
					public void run() {
						String text = "User is created! username : " + user.getEmail() 
						+ ", password:" + pwd
						+ ", with role: " + user.getRole().name();
						mailUtil.send(user.getEmail(), "User Register", text);
					}
				}).start();
			}
		}

	}

}
