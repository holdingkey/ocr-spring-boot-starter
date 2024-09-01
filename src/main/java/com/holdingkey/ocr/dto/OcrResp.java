package com.holdingkey.ocr.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class OcrResp {

    private List<WordsResp> wordsResult;

    private String logId;

    private Integer wordsResultNum;

    private String content;

}
