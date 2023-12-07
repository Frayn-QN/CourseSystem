 /***********************************************************************
 * Module:  Timetable.java
 * Author:  ASUS
 * Purpose: Defines the Class Timetable
 ***********************************************************************/

package org.course;
import java.util.*;

/** @pdOid 3f5e2b61-7f5e-40b4-94d7-7e5d1f5af6c5 */
public class Timetable {
   /** @pdOid 8148775b-8bc2-4722-8f54-90fe10ec6bc5 */
   // 学期有1-20周，每天有1-10节课

   public Map<Day, List<Integer>> classTimes;
   public int startWeek;
   /** @pdOid e30d7439-3797-4cae-8f1b-e6bb353b581b */
   public int endWeek;
   
   /** @param timetable
    * @pdOid e99e3aeb-d2d3-4a12-938b-79e216434fc8 */
   public boolean hasConflict(Timetable timetable) {
      // TODO: implement
      if(this.endWeek >= timetable.startWeek && timetable.endWeek >= this.startWeek
              && hasMapConflict(this.classTimes, timetable.classTimes))
         return true;
      return false;
   }

   // 检查两个 Map 是否存在冲突的方法
   private static boolean hasMapConflict(Map<Day, List<Integer>> map1, Map<Day, List<Integer>> map2) {
      for (Map.Entry<Day, List<Integer>> entry : map1.entrySet()) {
         Day day = entry.getKey();
         List<Integer> list1 = entry.getValue();
         List<Integer> list2 = map2.get(day);

         // 如果两个 Map 中都包含相同的星期，并且对应的列表存在相同元素，则认为存在冲突
         if (list2 != null && !Collections.disjoint(list1, list2)) {
            return true;
         }
      }
      return false;
   }

}