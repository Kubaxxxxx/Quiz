package model;

public class VysledekQuizu {
    private String jmenoHrace;
    private int skore;
    private int celkemOtazek;

    public VysledekQuizu(String jmenoHrace, int skore, int celkemOtazek) {
        this.jmenoHrace = jmenoHrace;
        this.skore = skore;
        this.celkemOtazek = celkemOtazek;
    }
}
