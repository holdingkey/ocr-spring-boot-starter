package com.holdingkey.ocr;

import com.holdingkey.ocr.basic.IPlatform;
import lombok.Data;

import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class OcrTemplate {

    private CopyOnWriteArrayList<IPlatform> platformList;

    public IPlatform platform(String name) {
        for (IPlatform platform : this.platformList) {
            if (platform.getPlatform().equals(name)) {
                return platform;
            }
        }
        return null;
    }

}
