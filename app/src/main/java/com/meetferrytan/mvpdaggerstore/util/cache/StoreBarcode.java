package com.meetferrytan.mvpdaggerstore.util.cache;

import com.meetferrytan.mvpdaggerstore.util.format.MD5Digest;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by ferrytan on 11/11/17.
 */
// TODO implement own caching key
public class StoreBarcode {
    private String mKey;
    private List<String> mPaths;
    private Map<String, String> mParameters;
    private File mUploadFile;
    private String mCacheKey;

    /**
     * Barcode constructor
     *
     * @param parameters API / form parameters
     * @param key        API url unique key
     * @param paths      API optional paths
     */
    public StoreBarcode(Map<String, String> parameters, String key, String... paths) {
        mKey = key;
        mParameters = parameters;
        mPaths = Arrays.asList(paths);

        mCacheKey = generateCacheKey();
    }

    public Map<String, String> getParameters() {
        return mParameters;
    }

    public List<String> getPaths() {
        return mPaths;
    }

    public File getUploadFile() {
        return mUploadFile;
    }

    /**
     * optional: set file to upload
     *
     * @param uploadFile
     */
    public void setUploadFile(File uploadFile) {
        mUploadFile = uploadFile;
    }

    public String getCacheKey() {
        return mCacheKey;
    }

    /**
     * Generate cache key immediately on class creation
     *
     * @return MD5 hash for unique cache key
     */

    public String generateCacheKey() {
        String cacheKey = mKey;

        for (String path : mPaths) {
            cacheKey = cacheKey.concat("/").concat(path);
        }

        if (mParameters != null) {
            cacheKey = cacheKey.concat("?p=" + urlEncodeUTF8(mParameters));
        }
        return MD5Digest.getHash(cacheKey);
    }

    private static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    private static String urlEncodeUTF8(Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        return sb.toString();
    }
}