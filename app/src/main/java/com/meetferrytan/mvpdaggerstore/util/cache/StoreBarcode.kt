package com.meetferrytan.mvpdaggerstore.util.cache

import com.meetferrytan.mvpdaggerstore.util.format.MD5Digest
import java.io.File
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.util.*

/**
 * Created by ferrytan on 11/11/17.
 */
// TODO implement own caching key

/**
 * Barcode constructor
 *
 * @param parameters API / form parameters
 * @param key        API url unique key
 * @param paths      API optional paths
 */
class StoreBarcode(val parameters: Map<String, String>?, val mKey: String, vararg paths: String) {
    val paths: List<String>
    /**
     * optional: set file to upload
     *
     * @param uploadFile
     */
    var uploadFile: File? = null
    val cacheKey: String?

    init {
        this.paths = Arrays.asList(*paths)

        cacheKey = generateCacheKey()
    }

    /**
     * Generate cache key immediately on class creation
     *
     * @return MD5 hash for unique cache key
     */

    fun generateCacheKey(): String? {
        var cacheKey = mKey

        for (path in paths) {
            cacheKey = cacheKey + "/" + path
        }

        if (parameters != null) {
            cacheKey = cacheKey + ("?p=" + urlEncodeUTF8(parameters))
        }
        return MD5Digest.getHash(cacheKey)
    }

    private fun urlEncodeUTF8(s: String): String {
        try {
            return URLEncoder.encode(s, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            throw UnsupportedOperationException(e)
        }

    }

    private fun urlEncodeUTF8(map: Map<*, *>): String {
        val sb = StringBuilder()
        for ((key, value) in map) {
            if (sb.length > 0) {
                sb.append("&")
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(key.toString()),
                    urlEncodeUTF8(value.toString())
            ))
        }
        return sb.toString()
    }
}