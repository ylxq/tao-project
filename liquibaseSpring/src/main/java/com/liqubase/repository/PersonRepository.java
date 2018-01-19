package com.liqubase.repository;

import com.liqubase.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tao_wc
 * @date 2018/1/19
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
