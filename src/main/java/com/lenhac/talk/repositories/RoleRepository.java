package com.lenhac.talk.repositories;


import com.lenhac.talk.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}