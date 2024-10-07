package kysh.corn.task.tracker.api.controllers;

import kysh.corn.task.tracker.api.controllers.helpers.ControllerHelper;
import kysh.corn.task.tracker.api.dto.TaskStateDto;
import kysh.corn.task.tracker.api.exceptions.BadRequestException;
import kysh.corn.task.tracker.api.factories.TaskStateDtoFactory;
import kysh.corn.task.tracker.store.entities.ProjectEntity;
import kysh.corn.task.tracker.store.entities.TaskStateEntity;
import kysh.corn.task.tracker.store.repositories.TaskStateRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class TaskStateController {

    TaskStateRepository taskStateRepository;

    TaskStateDtoFactory taskStateDtoFactory;

    ControllerHelper controllerHelper;

    public static final String GET_TASK_STATES = "/api/projects/{project_id}/task-states";
    public static final String CREATE_TASK_STATE = "/api/projects/{project_id}/task-states";
    public static final String DELETE_PROJECT = "/api/projects/{project_id}";

    @GetMapping(GET_TASK_STATES)
    public List<TaskStateDto> getTaskStates(@PathVariable(name = "project_id") Long projectId) {

        ProjectEntity project = controllerHelper.getProjectOrThrowException(projectId);

        return project
                .getTaskStates()
                .stream()
                .map(taskStateDtoFactory::makeTaskStateDto)
                .collect(Collectors.toList());
    }

    @PostMapping(CREATE_TASK_STATE)
    public TaskStateDto createTaskState(
            @PathVariable(name = "project_id") Long projectId,
            @RequestParam(name = "task_state_name") String taskStateName) {

        if (taskStateName.isBlank()) {
            throw new BadRequestException("Task state name can`t be empty.");
        }

        ProjectEntity project = controllerHelper.getProjectOrThrowException(projectId);

        project
                .getTaskStates()
                .stream()
                .map(TaskStateEntity::getName)
                .filter(anotherTaskStateName -> anotherTaskStateName.equals(taskStateName))
                .findAny()
                .ifPresent(it -> {
                    throw new BadRequestException(String.format("Task state \"%s\" already exists.", taskStateName));
                });

        TaskStateEntity taskState = taskStateRepository
                .saveAndFlush(

                )

    }
}