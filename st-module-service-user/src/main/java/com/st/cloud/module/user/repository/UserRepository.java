package com.st.cloud.module.user.repository;

import com.st.cloud.module.user.entity.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 你可以在这里添加自定义的查询方法
    // 例如：
    // User findByEmail(String email);
    // List<User> findByLastName(String lastName);
}
