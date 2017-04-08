/**
 * Created by Alexander on 08/04/2017.
 */
public class Skills {

    private int skill_id;
    private String area_of_skill;
    private int developer_id;

    @Override
    public String toString() {
        return "Skills{" +
                "skill_id=" + skill_id +
                ", area_of_skill='" + area_of_skill + '\'' +
                ", developer_id=" + developer_id +
                '}';
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getArea_of_skill() {
        return area_of_skill;
    }

    public void setArea_of_skill(String area_of_skill) {
        this.area_of_skill = area_of_skill;
    }

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }
}
