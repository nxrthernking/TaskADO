package entities;

import com.opencsv.bean.CsvBindByName;

public class Role {

    @CsvBindByName
    private Long id;

    @CsvBindByName
    private String name;


    public Role() {
    }


    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!(obj instanceof Role)){
            return false;
        }

        Role role = (Role) obj;
        return this.id.equals(role.id) && this.name.equals(role.name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
