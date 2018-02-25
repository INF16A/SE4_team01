package task20;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Block {
    private String type;
    private boolean activated = false;

    public Block(String type) {
        this.type = type;
    }

    String generateEnergy() {
        if (!activated)
            return "";

        Random r = new Random();
        char[] energy = new char[500];
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            energy[i] = '0';
            //have to implement it this way to stay deterministic
            positions.add(i);
        }

        for (int i = 0; i < 380; i++) {
            int pos = r.nextInt(positions.size());
            pos = positions.remove(pos);
            energy[pos] = '1';
        }
        return new String(energy);
    }

    public void activate() {
        activated = true;
    }

    public void deactivate() {
        activated = false;
    }

    public boolean isActivated() {
        return activated;
    }
}
