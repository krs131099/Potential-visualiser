import java.awt.Color;
public class Potential {

  public static Charge[] readCharges() {
    int n = StdIn.readInt();
    Charge[] a = new Charge[n];

    for(int i = 0;i < n; i++) {
      double x0 = StdIn.readDouble();
      double y0 = StdIn.readDouble();
      double q0 = StdIn.readDouble();
      a[i] = new Charge(x0,y0,q0);

    }
    return a;
  }


  public static Color toColor(double v) {
    v = 128+v/2.0e10;
    int t = 0;
    if(v>255) t = 255;
    else if(v>=0) t = (int) v;
    return new Color(t,t,t);
  }

  public static void main(String[] args) {
    Charge[] a = readCharges();
    int size = 800;
    Picture target = new Picture(size,size);

    for(int col = 0; col< size; col++) {
      for(int row = 0; row<size;row++) {
        double v = 0.0;
        for(int k = 0 ;k<a.length;k++) {
          double x = 1.0*col/size;
          double y = 1.0*row/size;
          v = v+a[k].potentialAt(x,y);
        }
        target.set(col,size-1-row,toColor(v));
      }
    }
    target.show();
  }



}
