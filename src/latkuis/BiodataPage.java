package latkuis;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BiodataPage extends JFrame {
    private JPanel panel;
    // NAMA
    JLabel lnama = new JLabel("Nama Mahasiswa:");
    JTextField namaMhs = new JTextField(15);

    // NIM
    JLabel lnim = new JLabel("NIM Mahasiswa:");
    JTextField nimMhs = new JTextField(9);
 
    // NILAI TUGAS
    JLabel lnilaiTugas = new JLabel("Nilai Tugas:");
    JTextField nilaiTugas = new JTextField(2);

    // NILAI QUIZ
    JLabel lnilaiQuiz = new JLabel("Nilai Quiz:");
    JTextField nilaiQuiz = new JTextField(2);

    // TIPE KELAS
    JLabel ltipeKelas = new JLabel("Tipe Kelas:");
    JRadioButton rbkelasPraktikum = new JRadioButton("Kelas Praktikum");
    JRadioButton rbkelasTeori = new JRadioButton("Kelas Teori");
       
    // MATA KULIAH
    JLabel lmataKuliah= new JLabel("Mata Kuliah");
    String[] namaMatkul = {"PBO", "SCPK", "Algo Lanjut"};
    JComboBox cbmataKuliah = new JComboBox<>(namaMatkul);
    
    // BUTTON 
    JButton btnSubmit = new JButton("Submit");
    JButton btnLogout = new JButton("Logout");
    
    public BiodataPage() {
        setTitle("Halaman Input Nilai");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(new EmptyBorder(8, 8, 8, 8));
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbkelasPraktikum);
        group.add(rbkelasTeori);
        rbkelasTeori.setSelected(true);
        
        btnSubmit.addActionListener(e -> handleSubmit());
        btnLogout.addActionListener(e -> handleLogout());
        
        panel.add(lnama);
        panel.add(namaMhs);
        panel.add(lnim);
        panel.add(nimMhs);
        panel.add(lnilaiTugas);
        panel.add(nilaiTugas);
        panel.add(lnilaiQuiz);
        panel.add(nilaiQuiz);
        panel.add(ltipeKelas);
        panel.add(rbkelasPraktikum);
        panel.add(new JLabel());
        panel.add(rbkelasTeori);
        panel.add(lmataKuliah);
        panel.add(cbmataKuliah);
        panel.add(btnSubmit);
        panel.add(btnLogout);
        
        add(panel);
        setVisible(true);
    }
    
    private void handleSubmit() {
        String nama = namaMhs.getText().trim();
        String nim = nimMhs.getText().trim();
       
        if (nama.isEmpty()) {
        JOptionPane.showMessageDialog(panel, "Nama Mahasiswa tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if (nim.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "NIM Mahasiswa tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Mahasiswa mhs = new Mahasiswa(
                nama,
                nim,
                Double.parseDouble(nilaiTugas.getText()),
                Double.parseDouble(nilaiQuiz.getText()),
                rbkelasTeori.isSelected() ? "Teori" : "Praktikum",
                (String) cbmataKuliah.getSelectedItem()
            );
            new MassagePage().showResult(mhs);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel, "Input Tidak Valid pada Baris Nilai!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(panel, "Ada Input yang Salah", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleLogout() {
        int confirm = JOptionPane.showConfirmDialog(panel, "Yakin ingin logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}
