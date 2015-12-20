package patterson.travis.usecase;

import java.util.List;

public class EmployeesAndJobs {

    private List<String> employees;
    private List<String> jobs;

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }
}
