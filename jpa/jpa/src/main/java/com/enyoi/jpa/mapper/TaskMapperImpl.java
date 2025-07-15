package com.enyoi.jpa.mapper;

import com.enyoi.jpa.dto.TaskDto;
import com.enyoi.jpa.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements GenericMapper<TaskDto, Task>{

    @Override
    public TaskDto modelToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setPublicationDate(task.getPublicationDate());
        return taskDto;
    }

    @Override
    public Task dtoToModel(TaskDto dto) {
        return null;
    }
}
