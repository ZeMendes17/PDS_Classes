package startypes;

import java.awt.*;

public class Star {
    private int x;
    private int y;
    private StarType st;

    public Star(StarType st, int x, int y) {
        this.st = st;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(st.getColor());
        g.fillOval(x, y , st.getSize(), st.getSize());
    }
}
