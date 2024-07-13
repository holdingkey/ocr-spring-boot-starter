package com.holdingkey.ocr.dto;

import lombok.Data;

import java.util.List;

@Data
public class OcrResp {

    private List<WordsResp> wordsResult;

    private String logId;

    private Integer wordsResultNum;

}
