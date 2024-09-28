package kysh.corn.task.tracker.store.repositories;

import kysh.corn.task.tracker.store.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
