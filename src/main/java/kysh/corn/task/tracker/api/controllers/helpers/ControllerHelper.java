package kysh.corn.task.tracker.api.controllers.helpers;

import kysh.corn.task.tracker.api.exceptions.NotFoundException;
import kysh.corn.task.tracker.store.entities.ProjectEntity;
import kysh.corn.task.tracker.store.repositories.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
@Transactional
public class ControllerHelper {

    ProjectRepository projectRepository;

    public ProjectEntity getProjectOrThrowException(Long projectId) {
        return projectRepository
                .findById(projectId)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format(
                                        "Project with this Id \"%s\" doesn't exist.",
                                        projectId
                                )
                        )
                );
    }
}
