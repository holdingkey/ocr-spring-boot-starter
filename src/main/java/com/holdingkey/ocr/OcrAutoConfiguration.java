package com.holdingkey.ocr;

import com.holdingkey.ocr.basic.IPlatform;
import com.holdingkey.ocr.platform.aip.AipPlatform;
import com.holdingkey.ocr.platform.tesseract.TesseractPlatform;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Configuration
public class OcrAutoConfiguration {

    @Resource
    private OcrProperties properties;

    @Bean
    @ConditionalOnClass(name = "com.baidu.aip.ocr.AipOcr")
    public List<AipPlatform> aipPlatform() {
        return this.properties.getAip().stream().map(aipConfig -> {
            AipPlatform platform = new AipPlatform();
            platform.setPlatform(aipConfig.getPlatform());
            platform.setConfig(aipConfig);
            return platform;
        }).collect(Collectors.toList());
    }

    @Bean
    public List<TesseractPlatform> tesseractPlatform() {
        return this.properties.getTesseract().stream().map(tesseractConfig -> {
            TesseractPlatform platform = new TesseractPlatform();
            platform.setPlatform(tesseractConfig.getPlatform());
            platform.setConfig(tesseractConfig);
            return platform;
        }).collect(Collectors.toList());
    }

    @Bean
    public OcrTemplate ocrTemplate(List<List<? extends IPlatform>> platformList) {
        OcrTemplate template = new OcrTemplate();
        template.setPlatformList(new CopyOnWriteArrayList<>());
        platformList.forEach(template.getPlatformList()::addAll);
        return template;
    }

}
