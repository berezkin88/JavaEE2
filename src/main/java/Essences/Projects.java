package Essences;

/**
 * Created by Alexander on 08/04/2017.
 */
public class Projects {

    private int project_id;
    private String project_title;
    private int company_id;
    private int customer_id;
    private int cost;

    @Override
    public String toString() {
        return "Essences.Projects{" +
                "project_id=" + project_id +
                ", project_title='" + project_title + '\'' +
                ", company_id=" + company_id +
                ", customer_id=" + customer_id +
                ", cost=" + cost +
                '}';
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
