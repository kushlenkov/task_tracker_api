package kysh.corn.task.tracker.store.repositories;

import kysh.corn.task.tracker.store.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
