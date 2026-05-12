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

    public String getJmenoHrace() {
        return jmenoHrace;
    }

    public int getSkore() {
        return skore;
    }

    public int getCelkemOtazek() {
        return celkemOtazek;
    }

    public int getProcenta() {
        if (celkemOtazek == 0) return 0;
        return (int) ((skore / (double) celkemOtazek) * 100);
    }

    public String getHodnoceni() {
        int procenta = getProcenta();
        if (procenta >= 90) return "Výborně!";
        if (procenta >= 70) return "Dobře!";
        if (procenta >= 50) return "Ujde to.";
        return "Příště lépe!";
    }
}
