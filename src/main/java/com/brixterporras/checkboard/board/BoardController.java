package com.brixterporras.checkboard.board;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brixterporras.checkboard.common.payload.ResponsePage;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping({ "", "/" })
    public ResponsePage<Board> getAll(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {

        return boardService.getAllBoard(page, size);
    }

    @GetMapping({ "/{id}", "/{id}/" })
    public ResponseEntity<Board> getBoardById(@PathVariable UUID id) {
        Board board = boardService.getBoardById(id);
        return ResponseEntity.ok(board);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<Board> add(@Valid @RequestBody Board board) {
        Board newBoard = boardService.addStore(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBoard);
    }

}
