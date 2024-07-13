package com.holdingkey.ocr.basic;

import com.holdingkey.ocr.dto.OcrResp;

public interface IPlatform {

    String getPlatform();

    OcrResp basicAccurateGeneral(byte[] img);

    OcrResp basicAccurateGeneral(String imgPath);

}
