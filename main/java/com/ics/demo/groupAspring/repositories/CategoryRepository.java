package com.ics.demo.groupAspring.repositories;

import com.ics.demo.groupAspring.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
