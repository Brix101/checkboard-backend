package com.brixterporras.checkboard.board;

import org.springframework.http.ResponseEntity;

import com.brixterporras.checkboard.common.payload.ResponsePage;

public interface BoardService {
    ResponsePage<Board> getAllBoard(int page, int size);

    ResponseEntity<Board> addStore(Board board);
}
