package com.meetferrytan.mvpdaggerstore.util.format;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class BufferedSourceConverterFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        if (!BufferedSource.class.equals(type)) {
            return null;
        }
        return (Converter<ResponseBody, BufferedSource>) ResponseBody::source;
    }
}