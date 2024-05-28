package Main;

import java.util.ArrayList;
import Bebidas.*;

public class Orden {
    public ArrayList<Bebidas> bebidasDeLaOrden = new ArrayList<>();
    private int totalOrden = 0;

    public int calculateTotalOrden() {
        for (Bebidas base : bebidasDeLaOrden) {
            totalOrden += base.getPrecio();
        }
        return totalOrden;
    }

    public int getTotalOrden() {
        return totalOrden;
    }
}
