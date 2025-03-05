package com.brixterporras.checkboard.board;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.brixterporras.checkboard.common.exception.NotFoundException;
import com.brixterporras.checkboard.common.payload.ResponsePage;

import jakarta.transaction.Transactional;

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
    public Board getBoardById(UUID id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Board not found with ID: " + id));

        return board;
    }

    @Transactional
    @Override
    public Board addStore(Board board) {
        Board newBoard = boardRepository.save(board);

        return newBoard;
    }

}
