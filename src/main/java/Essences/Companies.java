package Essences;

/**
 * Created by Alexander on 08/04/2017.
 */
public class Companies {

    private int company_id;
    private String company_name;
    private int number_of_empoyees;

    @Override
    public String toString() {
        return "Essences.Companies{" +
                "company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                ", number_of_empoyees=" + number_of_empoyees +
                '}';
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getNumber_of_empoyees() {
        return number_of_empoyees;
    }

    public void setNumber_of_empoyees(int number_of_empoyees) {
        this.number_of_empoyees = number_of_empoyees;
    }
}
