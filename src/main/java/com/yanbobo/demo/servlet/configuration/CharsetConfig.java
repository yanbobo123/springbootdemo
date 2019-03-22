package com.yanbobo.demo.servlet.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @describe: 使用java配置写一个字符编码配置类：中文乱码解决（方式三）
 * @author: yanbobo
 * @createdate: 2019/3/15 17:03
 */
@Configuration
public class CharsetConfig extends WebMvcConfigurerAdapter {

    /**
     * StringHttpMessageConverter是一个请求和响应信息的编码转换器，
     * 通过源码我们发现默认编码ISO-8859-1，不是UTF-8，
     * 所以我们只要通过配置将请求字符串转为UTF-8 即可
     * @return
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

}
