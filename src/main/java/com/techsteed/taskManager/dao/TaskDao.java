package com.techsteed.taskManager.dao;

import com.techsteed.taskManager.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskDao extends JpaRepository<Tasks, Long> {
    List<Tasks> findByStatus(Tasks.TaskStatus status);

    Tasks findByTitle(String title);
    Optional<Tasks> findById(Long id);
}
