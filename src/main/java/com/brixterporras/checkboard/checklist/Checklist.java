package com.brixterporras.checkboard.checklist;

import com.brixterporras.checkboard.board.Board;
import com.brixterporras.checkboard.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checklists")
public class Checklist extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean checked = false;

    @Column()
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
}
