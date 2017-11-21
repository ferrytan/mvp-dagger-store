package com.meetferrytan.mvpdaggerstore.util.cache;

import com.meetferrytan.mvpdaggerstore.util.format.MD5Digest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ferrytan on 11/11/17.
 */
// TODO implement own caching key
public class StoreBarcode {
    private String mKey;
    private List<String> mPaths;
    private String mParameters;
    private File mUploadFile;
    private String mCacheKey;

    /**
     * Barcode constructor
     *
     * @param parameters API / form parameters
     * @param key        API url unique key
     * @param paths      API optional paths
     */
    public StoreBarcode(String parameters, String key, String... paths) {
        mKey = key;
        mParameters = parameters;
        mPaths = Arrays.asList(paths);

        mCacheKey = generateCacheKey();
    }

    public String getParameters() {
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
    private String generateCacheKey() {
        String cacheKey = mKey;

        for (String path : mPaths) {
            cacheKey = cacheKey.concat("/").concat(path);
        }
        cacheKey = cacheKey.concat("?p=" + mParameters);

        return MD5Digest.getHash(cacheKey);
    }
}