package programmers.openchat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    class Message{
        String id;
        String message;

        public Message(String id, String message) {
            this.id = id;
            this.message = message;
        }

        public String toString(Map<String,String> userMap) {
            return userMap.get(id)+message;
        }
    }
    public String[] solution(String[] record) {
        String[] answer = {};
        List<Message> list = new ArrayList<>();
        Set<String> users = new HashSet<>();
        Map<String,String> userMap = new HashMap<>();
        for(String cur : record) {
            StringTokenizer st = new StringTokenizer(cur);
            String command =  st.nextToken();
            String user;
            String uid;
            switch (command){
                case "Enter":
                    uid = st.nextToken();
                    user = st.nextToken();
                    list.add(enterUser(userMap,uid,user));
                    break;
                case "Change":
                    uid = st.nextToken();
                    user = st.nextToken();
                    changeUser(userMap, uid, user);
                    break;
                case "Leave":
                    uid = st.nextToken();
                    list.add(leaveUser(userMap,uid));
                    break;
            }
        }
        List<String> retList = list.stream().map(cur->cur.toString(userMap)).collect(Collectors.toList());
        answer = retList.toArray(new String[0]);
        return answer;
    }

    public Message enterUser(Map<String,String> userMap, String uid, String user){
        userMap.put(uid,user);
        return new Message(uid,"님이 들어왔습니다.");
    }
    public void changeUser(Map<String,String> userMap, String uid, String user){
        userMap.put(uid,user);
    }
    public Message leaveUser(Map<String,String> userMap, String uid){
        return new Message(uid,"님이 나갔습니다.");
    }
}
