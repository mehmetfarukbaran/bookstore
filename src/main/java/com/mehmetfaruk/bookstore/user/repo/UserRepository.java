package com.mehmetfaruk.bookstore.user.repo;

import com.mehmetfaruk.bookstore.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
