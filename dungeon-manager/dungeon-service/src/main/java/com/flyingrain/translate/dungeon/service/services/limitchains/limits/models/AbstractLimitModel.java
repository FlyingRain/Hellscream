package com.flyingrain.translate.dungeon.service.services.limitchains.limits.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created on 3/29/18.
 *
 * @author wally
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractLimitModel {

}
