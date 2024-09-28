package kysh.corn.task.tracker.api.controllers;

import kysh.corn.task.tracker.api.dto.ProjectDto;
import kysh.corn.task.tracker.api.exceptions.BadRequestException;
import kysh.corn.task.tracker.api.factories.ProjectDtoFactory;
import kysh.corn.task.tracker.store.entities.ProjectEntity;
import kysh.corn.task.tracker.store.repositories.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class ProjectController {

    ProjectRepository projectRepository;

    ProjectDtoFactory projectDtoFactory;

    public static final String CREATE_PROJECT = "/api/projects";

    @PostMapping(CREATE_PROJECT)
    public ProjectDto createProject(@RequestParam String name) {

        projectRepository
                .findByName(name)
                .ifPresent(project -> {
                    throw new BadRequestException(String.format("Project \"%s\" already exist.", name));
                });



        //TODO: uncomment and insert entity in method
        return null;
//        return projectDtoFactory.makeProjectDro();
    }
}
