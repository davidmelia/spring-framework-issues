package org.springframework.issues.web;

import java.math.BigDecimal;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobabDataBinderInitializer {

   @InitBinder
   public void initDataBinder(WebDataBinder binder) {
      binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, true)); // this registration seems to be the pre cursor to the setAutoGrowNestedPaths error.
   }

}
