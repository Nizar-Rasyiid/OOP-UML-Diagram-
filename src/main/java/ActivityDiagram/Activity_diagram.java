/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActivityDiagram;

import java.util.ArrayList;
public class Activity_diagram {
    protected int id;
    protected String nama;
    protected ArrayList<LifelineActivity> lifeline;
    protected ArrayList<ControlFlow> controlflow;

    public Activity_diagram(int id, String nama) {
        this.id = id;
        this.nama = nama;
        this.lifeline = new ArrayList<>();
        this.controlflow = new ArrayList<>();
    }

    public void ubahNama(String nama) {
        this.nama = nama;
    }

    public void tambahControlFlow(ControlFlow cf) {
        this.controlflow.add(cf);
    }

    public void tambahLifeline(LifelineActivity la) {
        this.lifeline.add(la);
    }

    public void hapusControlFlow(ControlFlow cf) {
        this.controlflow.remove(cf);
    }

    public void hapusLifeline(LifelineActivity la) {
        this.lifeline.remove(la);
    }

    @Override
    public String toString() {
        return "Activity_diagram{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", lifeline=" + lifeline +
                ", controlflow=" + controlflow +
                '}';
    }
}