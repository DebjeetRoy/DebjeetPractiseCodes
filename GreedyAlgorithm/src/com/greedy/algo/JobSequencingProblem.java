package com.greedy.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencingProblem {

	public static class Job{
		int jobId;
		int deadline;
		int profit;
		
		Job(int id,int time, int prof){
			this.jobId = id;
			this.deadline = time;
			this.profit = prof;
		}
	}
	
	public static void main(String[] args) {
		int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
		//Job jobs[] = new Job[jobsInfo.length];
		
		List<Job> jobs = new ArrayList<>();
		
		for(int i=0; i<jobsInfo.length; i++) {
			jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));			
		}
		
		Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
		
		//descending order of profit
		List<Integer> seq = new ArrayList<>();
		int time = 0;
		for(int i=0; i<jobs.size(); i++) {
			Job curr = jobs.get(i);
			if(curr.deadline > time) {
				seq.add(curr.jobId);
				time++;
			}
		}
		System.out.println("Max Jobs = "+seq.size());
		for(int i=0; i<seq.size(); i++) {
			System.out.print(seq.get(i)+" ");
		}
		System.out.println();
	}
}
