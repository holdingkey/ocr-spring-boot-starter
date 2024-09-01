package com.holdingkey.ocr.basic;

import com.holdingkey.ocr.dto.OcrResp;

import java.io.File;

public interface IPlatform {

    String getPlatform();

    OcrResp basicAccurateGeneral(File file);

    OcrResp basicAccurateGeneral(byte[] img);

    OcrResp basicAccurateGeneral(String imgPath);

}
