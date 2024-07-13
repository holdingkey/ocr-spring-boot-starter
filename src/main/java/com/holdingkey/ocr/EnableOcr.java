package com.holdingkey.ocr;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({OcrProperties.class, OcrAutoConfiguration.class})
public @interface EnableOcr {
}
