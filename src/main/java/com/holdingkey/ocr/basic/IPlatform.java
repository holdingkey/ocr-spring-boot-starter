package com.holdingkey.ocr.basic;

import com.holdingkey.ocr.dto.OcrResponse;

public interface IPlatform {

    String getPlatform();

    OcrResponse basicAccurateGeneral(byte[] img);

    OcrResponse basicAccurateGeneral(String imgPath);

}
