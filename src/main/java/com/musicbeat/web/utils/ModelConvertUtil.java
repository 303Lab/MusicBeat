package com.musicbeat.web.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 视图类转换工具类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017 /01/20 19:43
 * @since 1.0.0
 */
public class ModelConvertUtil {
    private static Logger logger = Logger.getLogger(ModelConvertUtil.class);
    private static final String ViewModelPrefix = "com.musicbeat.web.model.viewModel.";

    /**
     * 把List.ModelName转化为List.ViewModelName
     *
     * @param source model list
     * @return view model list
     */
    public static JSONArray convert2ViewModelList(final List<?> source) {
        JSONArray target = new JSONArray();
        try {
            for (Object sourceObject : source) {
                Object targetObject = convert2ViewModel(sourceObject);
                target.add(targetObject);
            }
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
        return target;
    }

    /**
     * 把List.ModelName转化为List.ViewModelName且忽略NULL值
     *
     * @param source model list
     * @return view model list
     */
    public static JSONArray convert2ViewModelListIgnoreNull(final List<?> source) {
        JSONArray target = new JSONArray();
        try {
            for (Object sourceObject : source) {
                JSONObject targetObject = convert2ViewModelIgnoreNull(sourceObject);
                target.add(targetObject);
            }
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
        return target;
    }

    /**
     * 把@ModelName转化为@ViewModelName
     *
     * @param source model
     * @return view model
     */
    public static Object convert2ViewModel(final Object source) {
        Object target = null;
        String className = source.getClass().getSimpleName() + "ViewModel";
        try {
            Class clazz = Class.forName(ViewModelPrefix + className);
            target = clazz.newInstance();
            BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
        return target;
    }

    /**
     * 把@ModelName转化为@ViewModelName忽略NULL值
     *
     * @param source model
     * @return view model
     */
    public static JSONObject convert2ViewModelIgnoreNull(final Object source) {
        Object target = convert2ViewModel(source);
        return transformJsonObject(target);
    }

    private static JSONObject transformJsonObject(final Object src) {
        String jsonString = JSON.toJSONString(src);
        return JSON.parseObject(jsonString);
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || srcValue.equals("")) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}