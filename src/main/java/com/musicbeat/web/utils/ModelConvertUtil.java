package com.musicbeat.web.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 视图类转换工具类
 *
 * @auther windawings
 * @create 2017/01/20 19:43
 */
public class ModelConvertUtil {
  private static Logger logger = Logger.getLogger(ModelConvertUtil.class);
  private static final String ViewModelPrefix = "com.musicbeat.web.model.viewmodel.";

  /**
   * 把List<@ModelName>转化为List<@ViewModelName>
   *
   * @param source model list
   * @return view model list
   */
  public static List<Class<?>> Convert2ViewModelList(List<Class<?>> source) {
    List target = new ArrayList();
    try {
      for (Object source_object : source) {
        Object target_object = Convert2ViewModel(source_object);
        target.add(target_object);
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
  public static Object Convert2ViewModel(Object source) {
    Object target = null;
    String className = source.getClass().getSimpleName() + "ViewModel";
    try {
      Class clazz = Class.forName(ViewModelPrefix + className);
      target = clazz.newInstance();
      BeanUtils.copyProperties(source, target);
    } catch (Exception e) {
      logger.error(e, e.fillInStackTrace());
    }
    return target;
  }
}
