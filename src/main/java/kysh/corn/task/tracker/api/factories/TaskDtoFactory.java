package kysh.corn.task.tracker.api.factories;

import kysh.corn.task.tracker.api.dto.TaskDto;
import kysh.corn.task.tracker.store.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoFactory {

    public TaskDto makeTaskDto (TaskEntity entity) {

        return TaskDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .description(entity.getDescription())
                .build();
    }
}
