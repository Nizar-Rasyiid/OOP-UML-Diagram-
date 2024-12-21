/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActivityDiagram;

class LifelineActivity {
    private int id;
    private String name;

    public LifelineActivity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LifelineActivity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
