package kysh.corn.task.tracker.store.repositories;

import kysh.corn.task.tracker.store.entities.TaskStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long> {
}
