package Entities;

public class Role {

    private Long id;

    private String name;


    public Role() {
    }

    public Role(String name) {
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
