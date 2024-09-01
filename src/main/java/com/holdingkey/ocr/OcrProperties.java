package com.holdingkey.ocr;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "spring.ocr")
public class OcrProperties {

    private List<AipConfig> aip;

    private List<TesseractConfig> tesseract;

    @Data
    @Accessors(chain = true)
    public static class AipConfig {

        private String platform;

        private String appId;

        private String apiKey;

        private String secretKey;

        private Integer connectTimeout = 2000;

        private Integer socketTimeout = 60000;

    }

    @Data
    @Accessors(chain = true)
    public static class TesseractConfig {

        private String platform;

        private String language;

        private String dataPath;

    }

}
