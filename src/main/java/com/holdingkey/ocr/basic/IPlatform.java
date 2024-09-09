package com.holdingkey.ocr.basic;

import com.holdingkey.ocr.dto.OcrResponse;

import java.io.File;

public interface IPlatform {

    String getPlatform();

    OcrResponse basicAccurateGeneral(byte[] img);

    OcrResponse basicAccurateGeneral(File file);

    OcrResponse basicAccurateGeneral(String imgPath);

}
