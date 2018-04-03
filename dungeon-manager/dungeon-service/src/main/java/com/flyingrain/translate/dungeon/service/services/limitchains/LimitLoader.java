package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.AbstractLimitModel;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created on 3/30/18.
 *
 * @author wally
 */
@Component
public class LimitLoader {

    private static String PACKAGENAME = "com.flyingrain.translate.dungeon.service.services.limitchains.limits";

    private Map<String, Class<AbstractLimitModel>> limitModelsCache;

    public Map<String, Class<AbstractLimitModel>> loadLimitModels() {
        Path path = Paths.get("");
        return null;

    }
}
