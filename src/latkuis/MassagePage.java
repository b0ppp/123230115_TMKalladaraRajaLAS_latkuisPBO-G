package latkuis;

import javax.swing.*;

public class MassagePage {
    public void showResult(Mahasiswa mhs) {
        JOptionPane.showMessageDialog(null, mhs.getInfo(), "Hasil Akhir", JOptionPane.INFORMATION_MESSAGE);
    }
}

