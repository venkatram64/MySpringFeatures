package com.venkat.employee.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheInspectionService {
    private final CacheManager cacheManager;

    public CacheInspectionService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public int getCacheSize() {
        return cacheManager.getCacheNames().size();
    }

    public void displayCache() {
        cacheManager.getCacheNames().forEach(cacheName -> {
            Cache cache = cacheManager.getCache(cacheName);
            log.info(cacheName + ": and contents: " + cache.getNativeCache());
        });
    }
}
