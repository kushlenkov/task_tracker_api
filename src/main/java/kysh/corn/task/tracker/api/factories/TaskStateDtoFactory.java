package kysh.corn.task.tracker.api.factories;

import kysh.corn.task.tracker.api.dto.TaskStateDto;
import kysh.corn.task.tracker.store.entities.TaskStateEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class TaskStateDtoFactory {

    TaskDtoFactory taskDtoFactory;

    public TaskStateDto makeTaskStateDto(TaskStateEntity entity) {

        return TaskStateDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .ordinal(entity.getOrdinal())
                .createdAt(entity.getCreatedAt())
                .tasks(
                        entity
                                .getTasks()
                                .stream()
                                .map(taskDtoFactory::makeTaskDto)
                                .collect(Collectors.toList()))
                .build();
    }
}
