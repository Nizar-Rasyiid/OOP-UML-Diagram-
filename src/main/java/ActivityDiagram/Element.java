/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActivityDiagram;

public abstract class Element {
    protected int id;
    protected String type;
    protected String nama;
    protected String konten;
    
    public Element(int id, String type, String nama) {
        this.id = id;
        this.type = type;
        this.nama = nama;
    } 
    public void updateKonten(String konten){
        this.konten = konten;
    }
    public void updateNama(String nama){
        this.nama = nama;
    } 
}
