package com.holdingkey.ocr.platform.aip;

import cn.hutool.json.JSONUtil;
import com.baidu.aip.ocr.AipOcr;
import com.holdingkey.ocr.OcrProperties;
import com.holdingkey.ocr.basic.IPlatform;
import com.holdingkey.ocr.dto.OcrResponse;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class AipPlatform implements IPlatform {

    private static final Logger LOGGER = LoggerFactory.getLogger(AipPlatform.class);

    @Setter
    private OcrProperties.AipConfig config;

    private AipOcr client;

    @Setter
    @Getter
    private String platform;

    private AipOcr getClient() {
        if (client == null) {
            this.client = new AipOcr(this.config.getAppId(), this.config.getApiKey(), this.config.getSecretKey());
            this.client.setConnectionTimeoutInMillis(this.config.getConnectTimeout());
            this.client.setSocketTimeoutInMillis(this.config.getSocketTimeout());
        }
        return this.client;
    }

    public OcrResponse basicAccurateGeneral(byte[] img) {
        JSONObject resultJson = this.getClient().basicAccurateGeneral(img, new HashMap<>());
        OcrResponse ocrResponse = JSONUtil.toBean(resultJson.toString(), OcrResponse.class);
        LOGGER.info("[通用高精度文字识别] <文件二进制> <请求成功> <返回数据: {}>", resultJson);
        return ocrResponse;
    }

    public OcrResponse basicAccurateGeneral(String imgPath) {
        JSONObject resultJson = this.getClient().basicAccurateGeneral(imgPath, new HashMap<>());
        OcrResponse ocrResponse = JSONUtil.toBean(resultJson.toString(), OcrResponse.class);
        LOGGER.info("[通用高精度文字识别] <文件路径> <请求成功> <返回数据: {}>", resultJson);
        return ocrResponse;
    }

}
