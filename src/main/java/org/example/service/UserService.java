package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/*public List<User> findAll() {
		return USER_REPOSITORY.findAll();
	}*/

	/*@Transactional(isolation = Isolation.READ_COMMITTED)
	public String creditCalculate(Long id){

		User user = userRepository.findOne(id);

		if(user.getCreditScore() < 500){
			user.setStatus(false);
			return "Kredi alamaz.";
		}
		else if(user.getCreditScore()>= 500 && user.getCreditScore()<= 1000){
			return "Kredi alabilir.";
		}
		else{
			return "Kredi alamaz.";
		}
	}*/

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String creditCalculate2(User user){

		//User response = userRepository.findByIdentityAndIncome(user.getIdentity(), user.getIncome());
		User response = userRepository.findByIdentity(user.getIdentity());

		if(response.getCreditscore() < 500){
			response.setStatus(false);
			return "Kredi alamaz.";
		}
		else if(response.getCreditscore()>= 500 && response.getCreditscore()<= 1000 && response.getIncome() < 5000){
			return "Kredi alabilir : 10000TL";
		}
		else if(response.getCreditscore() >= 10000){
			return "Kredi alabilir : " + response.getIncome()* 4 ;
		}
		else{
			return "Kredi alamaz.";
		}
	}

}
