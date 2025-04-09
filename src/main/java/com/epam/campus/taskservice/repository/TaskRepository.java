package com.epam.campus.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epam.campus.taskservice.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
