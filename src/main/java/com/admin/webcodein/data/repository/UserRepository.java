package com.admin.webcodein.data.repository;

import com.admin.webcodein.data.entity.Room;
import com.admin.webcodein.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
