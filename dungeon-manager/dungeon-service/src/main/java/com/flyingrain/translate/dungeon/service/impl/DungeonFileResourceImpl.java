package com.flyingrain.translate.dungeon.service.impl;

import com.flyingrain.translate.dungeon.api.DungeonFileResource;
import com.flyingrain.translate.framework.annotaions.Resource;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * 图片上传
 * Created by wally on 17-9-10.
 */
@Component
@Resource
public class DungeonFileResourceImpl implements DungeonFileResource{
    @Override
    public int uploadImg(InputStream inputStream, FormDataContentDisposition dataContentDisposition) {
        return 0;
    }
}
