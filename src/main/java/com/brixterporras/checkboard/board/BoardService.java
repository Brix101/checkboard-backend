package com.brixterporras.checkboard.board;

import java.util.UUID;

import com.brixterporras.checkboard.common.payload.ResponsePage;

public interface BoardService {
    ResponsePage<Board> getAllBoard(int page, int size);

    Board getBoardById(UUID id);

    Board addStore(Board board);
}
