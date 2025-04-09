package com.epam.campus.taskservice.integration;

import com.epam.campus.taskservice.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// A Spring Boot integration test that uses an in-memory database (H2)
@SpringBootTest
@DirtiesContext
class TaskIntegrationTest {

    @Autowired
    private com.epam.campus.taskservice.repository.TaskRepository taskRepository;

    @Test
    void testGetTasks_fromRealDatabase() {
        // Set up data in the real (H2) database
        Task task1 = new Task();
        task1.setName("Task 1");
        taskRepository.save(task1);

        Task task2 = new Task();
        task2.setName(null);  // Null name for testing
        taskRepository.save(task2);

        // Retrieve tasks from the actual database
        List<Task> tasks = taskRepository.findAll();
        assertEquals(2, tasks.size(), "Should retrieve both tasks");
        assertNotNull(tasks.get(0).getName(), "Task 1 should not have a null name");
    }
}