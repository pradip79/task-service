package com.epam.campus.taskservice.service;

import com.epam.campus.taskservice.model.Task;
import com.epam.campus.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        //return taskRepository.findAll();
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getName() != null)
                .toList();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }
}