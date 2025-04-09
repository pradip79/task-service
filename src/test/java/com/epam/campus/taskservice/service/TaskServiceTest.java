package com.epam.campus.taskservice.service;

import com.epam.campus.taskservice.model.Task;
import com.epam.campus.taskservice.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void getAllTasks_returnsAllTasksWithCorrectDetails() {
        // Mock repository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
        TaskService taskService = new TaskService(mockRepository);

        // Prepare mock data with meaningful task details
        Task mockTask1 = new Task();
        mockTask1.setId(1L);
        mockTask1.setName("Test Task 1");

        Task mockTask2 = new Task();
        mockTask2.setId(2L);
        mockTask2.setName("Test Task 2");

        // Mock repository behavior
        Mockito.when(mockRepository.findAll()).thenReturn(Arrays.asList(mockTask1, mockTask2));

        // Actual test
        List<Task> tasks = taskService.getAllTasks();

        // Assert the size of the returned list
        assertEquals(2, tasks.size(), "Task list should contain 2 tasks");

        // Assert that the first task has correct details
        assertNotNull(tasks.get(0).getId(), "Task ID should not be null");
        assertEquals("Test Task 1", tasks.get(0).getName(), "Task name should match");

        // Assert that the second task has correct details
        assertEquals(2L, tasks.get(1).getId(), "Task ID should match");
        assertEquals("Test Task 2", tasks.get(1).getName(), "Task name should match");
    }
}