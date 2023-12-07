/***********************************************************************
 * Module:  CourseSubject.java
 * Author:  ASUS
 * Purpose: Defines the Class CourseSubject
 ***********************************************************************/

package org.course;
import java.util.*;

/** @pdOid 17d3e10b-91b4-4f2d-877d-9e4b3d9b6b4c */
public abstract class CourseSubject {
   /** @pdOid 37f2dd18-1a37-43c5-bd08-9968bc4a16cb */
   private List<CourseObserver> observers;

   public List<CourseObserver> getObservers() {
      return observers;
   }
   
   /** @param observer
    * @pdOid 339296d0-435b-4404-944d-af12db40cf35 */
   public void registerObserver(CourseObserver observer) {
      if(!observers.contains(observer)) {
         observers.add(observer);
      }
   }
   /** @param observer
    * @pdOid a2410423-f8ce-4de0-8266-3a06222677e9 */
   public void removeObserver(CourseObserver observer) {
      if(observers.contains(observer)) {
         observers.remove(observer);
      }
   }
   /** @pdOid 867f6f9c-1336-4cf4-b4a8-b19a04670cf8 */
   public abstract void notifyObserver();

}