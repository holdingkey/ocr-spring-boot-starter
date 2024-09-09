package com.holdingkey.ocr.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class OcrResponse {

    private List<WordsResponse> wordsResult;

    private String logId;

    private Integer wordsResultNum;

    private String content;

}
