package com.holdingkey.ocr.platform.tesseract;

import com.holdingkey.ocr.OcrProperties;
import com.holdingkey.ocr.basic.IPlatform;
import com.holdingkey.ocr.dto.OcrResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

@Slf4j
public class TesseractPlatform implements IPlatform {

    @Setter
    private OcrProperties.TesseractConfig config;

    @Setter
    @Getter
    private String platform;

    private Tesseract tesseract;

    private Tesseract getTesseract() {
        if (tesseract == null) {
            this.tesseract = new Tesseract();
        }
        return this.tesseract;
    }

    @Override
    public OcrResponse basicAccurateGeneral(File file) {
        try {
            String response = this.tesseract.doOCR(file);
            return new OcrResponse().setContent(response);
        } catch (TesseractException e) {
            log.error("[Tesseract OCR 识别异常] <异常原因：{}>", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public OcrResponse basicAccurateGeneral(byte[] img) {
        return null;
    }

    @Override
    public OcrResponse basicAccurateGeneral(String imgPath) {
        return null;
    }

}
