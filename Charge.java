public class Charge {

  private final double rx,ry;
  private final double q;

  public Charge(double x0, double y0,double q0) {
    rx = x0;ry = y0; q = q0;
  }

  public double potentialAt(double x, double y) {
    double k = 8.99e09;
    double dx = x-rx;
    double dy = y - ry;
    return k*q/Math.sqrt(dx*dx + dy*dy) ;
  }

  public String toString() {
    return q + "at " + "(" + rx+", "+ry+")" ;
  }

  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    Charge c = new Charge(0.51,0.63,21.3);
    StdOut.println(c.potentialAt(x,y));
  }
}
