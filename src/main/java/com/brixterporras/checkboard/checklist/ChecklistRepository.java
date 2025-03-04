package com.brixterporras.checkboard.checklist;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist,UUID> {

}
