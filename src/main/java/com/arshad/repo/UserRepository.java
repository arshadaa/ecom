package com.arshad.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.arshad.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	@Modifying
	@Query("UPDATE User SET password=:encPwd WHERE id=:userId")
	void updateUserPwd(String encPwd,Long userId);
}
