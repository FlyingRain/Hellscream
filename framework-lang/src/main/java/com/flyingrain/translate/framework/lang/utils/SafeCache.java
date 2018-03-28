package com.flyingrain.translate.framework.lang.utils;

import java.util.WeakHashMap;

/**
 * 内存安全的缓存
 * Created by wally on 18-3-18.
 */
public class SafeCache {

    private ThreadLocal<WeakHashMap>  cache = new ThreadLocal<>();


    
}
