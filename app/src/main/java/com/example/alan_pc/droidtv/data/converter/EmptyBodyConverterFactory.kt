package com.example.alan_pc.droidtv.data.converter

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * Created by ALAN-PC on 25/05/2018
 */

class EmptyBodyConverterFactory : Converter.Factory() {

    //TODO Implements if is necessary modify object
    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return super.responseBodyConverter(type, annotations, retrofit)
    }
}