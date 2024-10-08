package com.example.CarRentTest.Service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CarRentTest.Repository.UserRepository;
import com.example.CarRentTest.vo.User;
@Service
public class UserService {
     // 自動注入 UserRepository 的實例
     @Autowired
     private UserRepository userRepository;

    //利用name作為登入帳號
    public Optional<User> findByName(String name) {
        return Optional.ofNullable(userRepository.findByName(name));
    }

    //利用emailOrphone作為登入帳號
    public Optional<User> findByEmailOrPhone(String emailOrphone) {
       User user = userRepository.findByEmail(emailOrphone);
       if(user == null){
        user = userRepository.findByPhone(emailOrphone);
       }
       if(user == null){
        user = userRepository.findByName(emailOrphone);
       }
       return Optional.ofNullable(user);
    }

    public void logoutUser(String name) {
        User user = userRepository.findByName(name);
        if (user != null) {
            userRepository.save(user);
        }
    }
    
    public User save(User user) {
        // 將用戶對象保存到數據庫中並返回更新後的用戶對象
        return userRepository.save(user);
    }

}

