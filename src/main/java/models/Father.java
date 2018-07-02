    package models;

    import javax.persistence.*;


    @Entity
    @Table(name="fathers")
    public class Father {
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private String specialSkill;

    public Father(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
        public int getId() {
            return id;
        }
        @Column(name ="first_name")
        public String getFirstName() {
            return firstName;
        }
        @Column(name ="last_name")
        public String getLastName() {
            return lastName;
        }
        @Column(name ="age")
        public int getAge() {
            return age;
        }
        @Column(name ="Special_skill")
        public String getSpecialSkill() {
            return specialSkill;
        }

        public void setSpecialSkill(String specialSkill) {
            this.specialSkill = specialSkill;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


