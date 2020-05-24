
package com.cloud.justyou.util.face.json;


public class Result {

    private String face_token;
    public User_list[] user_list;
    public void setFace_token(String face_token) {
         this.face_token = face_token;
     }
     public String getFace_token() {
         return face_token;
     }

    public void setUser_list(User_list[] user_list) {
         this.user_list = user_list;
     }
     public User_list[] getUser_list() {
         return user_list;
     }

}