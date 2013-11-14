package org.springframework.issues.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

   @RequestMapping("/foo")
   public ModelAndView search() {
      return new ModelAndView("showMessage", "model", new HelloWorldModel());
   }

   /**
    * This will result in a "java.lang.IllegalStateException: DataBinder is already initialized - call setAutoGrowNestedPaths before other configuration methods at
    * org.springframework.util.Assert.state(Assert.java:385) . . ."
    * @param binder
    */
   @InitBinder(value = "model")
   public void initBinder(WebDataBinder binder) {
      binder.setAutoGrowNestedPaths(false);
   }

   public static class HelloWorldModel {
      public String message = "Hello World, Spring 3.0!";

      public String getMessage() {
         return message;
      }

      public void setMessage(String message) {
         this.message = message;
      }

   }
}
