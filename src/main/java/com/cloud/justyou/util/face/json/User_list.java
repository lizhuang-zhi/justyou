
package com.cloud.justyou.util.face.json;


public class User_list {

    private String group_id;
    private String user_id;
    private String user_info;
    public Double score;
    public void setGroup_id(String group_id) {
         this.group_id = group_id;
     }
     public String getGroup_id() {
         return group_id;
     }

    public void setUser_id(String user_id) {
         this.user_id = user_id;
     }
     public String getUser_id() {
         return user_id;
     }

    public void setUser_info(String user_info) {
         this.user_info = user_info;
     }
     public String getUser_info() {
         return user_info;
     }

    public void setScore(Double score) {
         this.score = score;
     }
     public Double getScore() {
         return score;
     }

}