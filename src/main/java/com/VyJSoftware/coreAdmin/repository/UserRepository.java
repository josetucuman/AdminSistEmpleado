package com.VyJSoftware.coreAdmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VyJSoftware.coreAdmin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
