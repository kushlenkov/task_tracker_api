package kysh.corn.task.tracker.api.factories;

import kysh.corn.task.tracker.api.dto.ProjectDto;
import kysh.corn.task.tracker.store.entities.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoFactory {

    public ProjectDto makeProjectDro(ProjectEntity entity) {

        return ProjectDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .updatedAt(entity.getUpdatedAt())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}