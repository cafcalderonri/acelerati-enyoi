package com.enyoi.jpa.mapper;

import com.enyoi.jpa.dto.TaskDto;
import com.enyoi.jpa.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    public List<TaskDto> mapTaskListToTaskDtoList(List<Task> tasks){
        List<TaskDto> response = new ArrayList<>();
        for(Task task: tasks){
            TaskDto taskDto = mapTaskToTaskDto(task);
            response.add(taskDto);
        }
        return response;
    }

    public TaskDto mapTaskToTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setPublicationDate(task.getPublicationDate());
        return taskDto;
    }


}
