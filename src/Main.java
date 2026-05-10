import manager.SpravceKvizu;
import ui.KvizOkno;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SpravceKvizu spravce = new SpravceKvizu();
        new KvizOkno("Testovaci hrac", spravce).setVisible(true);
    }
}