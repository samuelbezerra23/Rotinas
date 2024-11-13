package com.example.rotinas_diarias.service;

import com.example.rotinas_diarias.model.TaskModel;
import com.example.rotinas_diarias.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    public TaskModel createTask(TaskModel taskModel) {
        logger.info("Creating task with description: {}", taskModel.getDescricao());
        return taskRepository.save(taskModel);
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(Long id) {
        return taskRepository.findById(id);
    }


    public TaskModel updateTask(Long id, TaskModel updatedTask) {
        return taskRepository.findById(id)
            .map(task -> {
                task.setDescricao(updatedTask.getDescricao());
                task.setDataInicio(updatedTask.getDataInicio());
                task.setDataTermino(updatedTask.getDataTermino());
                task.setStatus(updatedTask.getstatus());
                task.setPrioridade(updatedTask.getprioridade());
                return taskRepository.save(task);
            }).orElse(null);
    }
    
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
