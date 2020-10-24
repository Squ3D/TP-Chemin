package Chemin;

public enum Moyen {BUS(0.1, 40), CAR(0.3, 50), TRAIN(1, 70);
    double cout;
    double v;
    Moyen(double _cout, double _v){cout = _cout; v = _v;}
}
