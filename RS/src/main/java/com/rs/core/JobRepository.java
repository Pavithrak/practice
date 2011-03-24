package com.rs.core;

import java.util.Map;

public class JobRepository {
    String query;
    DBHelper dbHelper;

    public JobRepository() {
        this.query = "";
        this.dbHelper = DBHelper.getInstance();
    }

    private void basicQuery() {
        query = "select * from Job";
    }

    private void addConjunction(String field, String value) {
        query += (query.indexOf("where") == -1) ? " where " + field + "='" + value + "'" : " and " + field + "='" + value + "'";
    }

    public Job[] getJobs(Map<String, String[]> paramNameValue) {
        buildQuery(paramNameValue);
        return buildJob(dbHelper.retrieveFromTable(query));
    }

    private Job[] buildJob(String[][] jobRecords) {
        Job[] jobList = new Job[jobRecords.length];
        int i=0;
        for ( String[] record : jobRecords){
            jobList[i++] = new Job(Integer.parseInt(record[5]),record[0], record[1], record[2], record[3], record[4]);
        }
        return jobList;
    }

    private void buildQuery(Map<String, String[]> paramNameValue) {
        basicQuery();
        for (Map.Entry<String, String[]> entry : paramNameValue.entrySet()) {
            if (!entry.getValue()[0].equals("Any"))
                addConjunction(entry.getKey(), entry.getValue()[0]);
        }
    }

    public Job[] getJobsWithID(int[] appliedJob) {
        basicQuery();
        for(int id : appliedJob){
          addDisjunction("job_id",id);
        }
        return buildJob(dbHelper.retrieveFromTable(query));
    }

    private void addDisjunction(String field, int value) {
        query += (query.indexOf("where") == -1) ? " where " + field + "=" + value  : " or " + field + "=" + value;
    }
}
