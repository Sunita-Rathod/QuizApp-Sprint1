package com.qna.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.qna.app.model.User;

public interface UserDao extends JpaRepository<User, Integer> {


}
