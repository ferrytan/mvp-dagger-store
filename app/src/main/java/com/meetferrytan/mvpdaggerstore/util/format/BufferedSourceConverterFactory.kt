package com.meetferrytan.mvpdaggerstore.util.format

import okhttp3.ResponseBody
import okio.BufferedSource
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class BufferedSourceConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?,
                                       retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return if (BufferedSource::class.java != type) {
            null
        } else Converter<ResponseBody, BufferedSource> { it.source() }
    }
}