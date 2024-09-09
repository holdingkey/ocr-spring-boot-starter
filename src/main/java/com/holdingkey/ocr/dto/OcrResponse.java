package com.holdingkey.ocr.dto;

import lombok.Data;

import java.util.List;

@Data
public class OcrResponse {

    private List<WordsResponse> wordsResult;

    private String logId;

    private Integer wordsResultNum;

}
