package programmers.c30l42627;

import java.util.*;

class Job{
    int start;
    int time;
    int turnAroundTime;

    public Job(int start, int time, int turnAroundTime) {
        this.start = start;
        this.time = time;
        this.turnAroundTime = turnAroundTime;
    }

    public int getStart() {
        return start;
    }

    public int getTime() {
        return time;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        List<Job> list = new ArrayList<>();
        for(int i=0;i<jobs.length;i++){
            list.add(new Job(jobs[i][0],jobs[i][1],0));
        }
        list.sort(Comparator.comparing(Job::getStart));
        List<Job> queue = new LinkedList<>();
        int currentTime = 0;
        while(list.size() > 0 || queue.size()>0){
            if(queue.isEmpty()){
                Job job = list.get(0);
                list.remove(0);
                currentTime = job.start;
                queue.add(job);
                pushQueue(list, queue, currentTime);
                queue.sort(Comparator.comparing(Job::getTime));
            }
            else{

                Job job = queue.get(0);
                queue.remove(0);
                currentTime += job.time;
                answer+=(currentTime-job.start);

                //현재 시간보다 startTime이 작은 아이들을 queue에 담아줌.
                pushQueue(list, queue, currentTime);
                queue.sort(Comparator.comparing(Job::getTime));
            }
        }
        return answer;
    }

    private void pushQueue(List<Job> list, List<Job> queue, int currentTime) {
        Job job;
        for(int i = 0; i< list.size(); i++){
            job = list.get(i);
            if(currentTime >= job.start){
                list.remove(i);
                i--;
                queue.add(job);
            }
            else{
                break;
            }
        }
    }
}
