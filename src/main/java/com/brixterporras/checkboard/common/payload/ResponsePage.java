package com.brixterporras.checkboard.common.payload;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class ResponsePage<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    public ResponsePage() {

    }

    public ResponsePage(List<T> content, int page, int size, long totalElements, int totalPages) {
        setContent(content);
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public ResponsePage(Page<T> page) {

        List<T> content = page.getNumberOfElements() == 0 ? Collections.emptyList() : page.getContent();

        setContent(content);
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalElements = page.getTotalElements();
    }

    public List<T> getContent() {
        return content == null ? null : new ArrayList<>(content);
    }

    public final void setContent(List<T> content) {
        if (content == null) {
            this.content = null;
        } else {
            this.content = Collections.unmodifiableList(content);
        }
    }

}
