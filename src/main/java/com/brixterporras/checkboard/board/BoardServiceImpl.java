package com.brixterporras.checkboard.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brixterporras.checkboard.common.payload.ResponsePage;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public ResponsePage<Board> getAllBoard(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        Page<Board> boards = boardRepository.findAll(pageable);

        return new ResponsePage<Board>(boards);
    }

    @Override
    public ResponseEntity<Board> addStore(Board board) {
        Board newBoard = boardRepository.save(board);

        return new ResponseEntity<Board>(newBoard, HttpStatus.CREATED);
    }
}
